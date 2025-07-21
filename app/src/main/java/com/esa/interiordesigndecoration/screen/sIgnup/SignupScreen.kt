package com.esa.interiordesigndecoration.screen.sIgnup

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.TopBar
import com.esa.interiordesigndecoration.data.viewmodel.AuthState
import com.esa.interiordesigndecoration.data.viewmodel.AuthWithGoogle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun SignupScreen(
    navController: NavController,
    modifier: Modifier = Modifier
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }
    var passwordConfirmVisible by remember { mutableStateOf(false) }
    var isLoading by remember { mutableStateOf(false) }
    val context = LocalContext.current
    val authWithGoogle = remember { AuthWithGoogle(context) }
    val coroutineScope = rememberCoroutineScope()
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(10.dp))
        TopBar(
            onBackClicked = {
                navController.navigate("launch")
            },
            topBarTitle = stringResource(R.string.topbar_text_create_account),
            modifier = Modifier
                .width(300.dp)
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(40.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                shape = RoundedCornerShape(27.dp),
                label = {
                    Text(
                        text = "email"
                    )
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                ),
                singleLine = true,
                modifier = Modifier
                    .width(330.dp)
                    .height(65.dp)
            )
            Spacer(Modifier.height(30.dp))
            OutlinedTextField(
                value = password,
                onValueChange = { password = it },
                shape = RoundedCornerShape(27.dp),
                label = {
                    Text(
                        text = "password"
                    )
                },
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val desc = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordVisible = !passwordVisible }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = desc,
                            tint = if (passwordVisible) Color.Black else Color.Red
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                ),
                modifier = Modifier
                    .width(330.dp)
                    .height(65.dp),
                singleLine = true
            )
            Spacer(Modifier.height(30.dp))
            OutlinedTextField(
                value = confirmPassword,
                onValueChange = { confirmPassword = it },
                shape = RoundedCornerShape(27.dp),
                label = {
                    Text(
                        text = "confirm password"
                    )
                },
                visualTransformation = if (passwordConfirmVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon =
                        if (passwordConfirmVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val desc = if (passwordConfirmVisible) "Hide password" else "Show password"
                    IconButton(onClick = { passwordConfirmVisible = !passwordConfirmVisible }) {
                        Icon(
                            imageVector = icon,
                            contentDescription = desc,
                            tint = if (passwordConfirmVisible) Color.Black else Color.Red
                        )
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                ),
                modifier = Modifier
                    .width(330.dp)
                    .height(65.dp),
                singleLine = true
            )
            Spacer(Modifier.height(50.dp))
            Button(
                onClick = {
                    if (password != confirmPassword) {
                        Toast.makeText(
                            context,
                            "confirm password is not the same with password",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else if (email.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()){
                        Toast.makeText(
                            context,
                            "email or password and confirm password can't be empty",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    else {
                        authWithGoogle.signup(email = email, password = confirmPassword)
                            .onEach { response ->
                                when (response) {
                                    is AuthState.Loading -> {
                                        isLoading = true
                                    }
                                    is AuthState.Authenticated -> {
                                        isLoading = false
                                        navController.navigate("homePage") {
                                            popUpTo(0)
                                        }
                                    }
                                    is AuthState.Error -> {
                                        isLoading = false
                                        Toast.makeText(
                                            context,
                                            response.message,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    else -> Unit
                                }
                            }
                            .launchIn(coroutineScope)
                    }
                },
                enabled = !isLoading,
                colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
                modifier = Modifier
                    .width(180.dp)
                    .height(50.dp)
            ) {
                Text(
                    text = stringResource(R.string.signup_btn_sign_up)
                )
            }
            Spacer(Modifier.height(173.dp))
            Text(
                text = stringResource(R.string.or_sign_up_with)
            )
            Spacer(Modifier.height(15.dp))
            Row {
                Image(
                    painter = painterResource(R.drawable.facebookicon),
                    contentDescription = "facebook icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {

                        }
                )

                Spacer(Modifier.width(20.dp))

                Image(
                    painter = painterResource(R.drawable.googleicon),
                    contentDescription = "google icon",
                    modifier = Modifier
                        .size(40.dp)
                        .clickable {
                            authWithGoogle.signInWIthGoogle().onEach { response ->
                                when (response) {
                                    is AuthState.Authenticated -> {
                                        isLoading = false
                                        navController.navigate("homePage") {
                                            popUpTo(0)
                                        }
                                    }
                                    is AuthState.Error -> {
                                        isLoading = false
                                        Toast.makeText(
                                            context,
                                            response.message,
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                    else -> Unit
                                }
                            }
                                .launchIn(coroutineScope)
                        }
                )
            }
            Spacer(Modifier.height(20.dp))
            Row {
                Text(
                    text = "Already have an account?",
                    color = Color.Gray,
                )

                Spacer(Modifier.width(5.dp))

                Text(
                    text = "Login",
                    color = Color(0xFFCC7861),
                    modifier = Modifier
                        .clickable {
                            navController.navigate("login")
                        }
                )
            }
        }
    }
}