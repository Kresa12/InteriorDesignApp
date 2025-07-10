package com.esa.interiordesigndecoration.data.viewmodel

import android.content.Context
import android.util.Log
import androidx.credentials.CredentialManager
import androidx.credentials.CustomCredential
import androidx.credentials.GetCredentialRequest
import com.esa.interiordesigndecoration.R
import com.google.android.libraries.identity.googleid.GetGoogleIdOption
import com.google.android.libraries.identity.googleid.GoogleIdTokenCredential
import com.google.android.libraries.identity.googleid.GoogleIdTokenParsingException
import com.google.firebase.Firebase
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.auth
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import java.security.MessageDigest
import java.util.UUID

class AuthWithGoogle(private val context: Context) {
    val auth = Firebase.auth

    private fun createNonce(): String {
        val rowNonce = UUID.randomUUID().toString()
        val bytes = rowNonce.toByteArray()
        val md = MessageDigest.getInstance("SHA-256")
        val digest = md.digest(bytes)

        return digest.fold("") { str, it ->
            str + "%02x".format(it)
        }
    }

    fun login(email: String, password: String): Flow<AuthState> = callbackFlow {
        if (email.isEmpty() && password.isEmpty()) {
            trySend(AuthState.Error("Email or password can't be empty"))
        }
        trySend(AuthState.Loading)
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    trySend(AuthState.Authenticated)
                } else {
                    trySend(AuthState.Error(task.exception?.message ?: "Something went wrong"))
                }
            }
        awaitClose()
    }

    fun signout(): Flow<AuthState> = callbackFlow{
        auth.signOut()
        trySend(AuthState.Unauthenticated)
        awaitClose()
    }

    fun signInWIthGoogle(): Flow<AuthState> = callbackFlow {
        val googleOption = GetGoogleIdOption.Builder()
            .setFilterByAuthorizedAccounts(false)
            .setServerClientId(context.getString(R.string.web_client_id))
            .setAutoSelectEnabled(false)
            .setNonce(createNonce())
            .build()

        val request = GetCredentialRequest.Builder()
            .addCredentialOption(googleOption)
            .build()

        try {
            val credentialManager = CredentialManager.create(context)
            Log.d("AuthWithGoogle", "Starting Google Sign In")
            val result = credentialManager.getCredential(
                context = context,
                request = request
            )
            Log.d("AuthWithGoogle", "Credential received: ${result.credential::class.java}")
            val credential = result.credential
            if (credential is CustomCredential) {
                if (credential.type == GoogleIdTokenCredential.TYPE_GOOGLE_ID_TOKEN_CREDENTIAL) {
                    try {
                        val googleIdTokenCredential = GoogleIdTokenCredential
                            .createFrom(credential.data)

                        val firebaseCredential = GoogleAuthProvider
                            .getCredential(googleIdTokenCredential.idToken, null)

                        auth.signInWithCredential(firebaseCredential)
                            .addOnCompleteListener { task ->
                                if (task.isSuccessful) {
                                    trySend(AuthState.Authenticated)
                                } else {
                                    Log.e("AuthWithGoogle", "Firebase login gagal", task.exception)
                                    trySend(AuthState.Error(task.exception?.localizedMessage ?: "Sign-in failed"))
                                }
                            }

                    } catch (e : GoogleIdTokenParsingException) {
                        trySend(AuthState.Error(e.message ?: "Something went wrong"))
                    }
                }
            }
        }catch (e : Exception){
            trySend(AuthState.Error(e.message ?: "Something went wrong"))
        }
        awaitClose()
    }
}