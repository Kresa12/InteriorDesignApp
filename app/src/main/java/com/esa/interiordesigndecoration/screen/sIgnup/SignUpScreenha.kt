package com.esa.interiordesigndecoration.screen.sIgnup

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.ButtonSignUp
import com.esa.interiordesigndecoration.component.SignUpForm
import com.esa.interiordesigndecoration.component.SinUpWithFacebookAndGoogle
import com.esa.interiordesigndecoration.component.TopBar
import com.esa.interiordesigndecoration.data.viewmodel.AuthState
import com.esa.interiordesigndecoration.data.viewmodel.AuthViewModel

@Composable
fun SignUpScreenha(
    onBackClicked : () -> Unit = {},
    authViewModel: AuthViewModel,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val authState = authViewModel.authState.observeAsState()
    val context = LocalContext.current
    LaunchedEffect(authState.value) {
        when(authState.value){
            is AuthState.Authenticated -> navController.navigate("homePage")
            is AuthState.Error -> Toast.makeText(
                context,
                (authState.value as AuthState.Error).message,
                Toast.LENGTH_SHORT).show()
            else -> Unit
        }
    }
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(60.dp))
        TopBar(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.topbar_text_create_account),
            modifier = Modifier
                .width(300.dp)
                .padding(start = 20.dp)
        )
        SignUpForm()
        Spacer(Modifier.height(20.dp))
        ButtonSignUp()
        Spacer(Modifier.height(15.dp))
        SinUpWithFacebookAndGoogle()
    }
}