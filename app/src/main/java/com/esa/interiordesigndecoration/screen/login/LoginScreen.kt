package com.esa.interiordesigndecoration.screen.login
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.ButtonLoginAndForgetPasswordUI
import com.esa.interiordesigndecoration.component.LoginForm
import com.esa.interiordesigndecoration.component.SinUpWithFacebookAndGoogle
import com.esa.interiordesigndecoration.component.TopBarLogin

@Composable
fun LoginScreen(navController: NavController) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(Modifier.height(60.dp))

        TopBarLogin(
            navController = navController,
            modifier = Modifier
                .width(245.dp)
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
            navController = navController
        )

        Spacer(Modifier.height(100.dp))

        SinUpWithFacebookAndGoogle()
    }
}



//@Preview
//@Composable
//private fun LoginScreenPrev() {
//    LoginScreen()
//}