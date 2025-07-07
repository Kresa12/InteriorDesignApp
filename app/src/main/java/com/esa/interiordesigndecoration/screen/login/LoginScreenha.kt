package com.esa.interiordesigndecoration.screen.login
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.ButtonLoginAndForgetPasswordUI
import com.esa.interiordesigndecoration.component.LoginForm
import com.esa.interiordesigndecoration.component.SinUpWithFacebookAndGoogle
import com.esa.interiordesigndecoration.component.TopBar
import com.esa.interiordesigndecoration.data.viewmodel.AuthState
import com.esa.interiordesigndecoration.data.viewmodel.AuthViewModel

@Composable
fun LoginScreenha(
    forgotPassword : () -> Unit = {},
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
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(60.dp))
        TopBar(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.title_log_in_screen),
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(45.dp))
        Column(
            modifier = Modifier
                .padding(start = 40.dp)
        ) {
            Text(
                text = stringResource(R.string.welcome_text_login),
                fontWeight = FontWeight.SemiBold,
                fontSize = 24.sp
            )
            Spacer(Modifier.height(8.dp))
            Text(
                text = stringResource(R.string.login_text_screen)
            )
        }
        LoginForm()
        Spacer(Modifier.height(55.dp))
        ButtonLoginAndForgetPasswordUI(
            email = email,
            password = password,
            forgotPassword = forgotPassword
        )
        Spacer(Modifier.height(100.dp))
        SinUpWithFacebookAndGoogle()
    }
}