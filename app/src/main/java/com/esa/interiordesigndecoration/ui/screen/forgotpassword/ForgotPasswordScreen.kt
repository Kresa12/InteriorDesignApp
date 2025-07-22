package com.esa.interiordesigndecoration.ui.screen.forgotpassword

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.ui.component.TopBar
import com.esa.interiordesigndecoration.viewmodel.AuthState
import com.esa.interiordesigndecoration.viewmodel.AuthWithGoogle
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    var email by remember { mutableStateOf("") }
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
            onBackClicked = { navController.navigate("login") },
            topBarTitle = stringResource(R.string.title_reset_password_screen),
            modifier = Modifier
                .width(300.dp)
                .padding(start = 20.dp)
        )
        Spacer(Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.reset_password_text),
            fontWeight = FontWeight.Bold,
            fontSize = 25.sp,
            modifier = Modifier
                .padding(start = 40.dp)
        )
        Spacer(Modifier.height(10.dp))
        Text(
            text = stringResource(R.string.forgot_pass_desc),
            modifier = Modifier
                .padding(start = 40.dp, end = 40.dp)
        )
        Spacer(Modifier.height(50.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .height(567.dp)
                .clip(RoundedCornerShape(25.dp))
                .background(Color(0xFFFAF0E6)),
        ) {
            Spacer(Modifier.height(50.dp))
            Column(
                modifier = Modifier
                    .width(313.dp)
            ) {
                Text(
                    text = "Enter Yor Email Address",
                    fontWeight = FontWeight.SemiBold
                )
                Spacer(Modifier.height(10.dp))
                OutlinedTextField(
                    value = email,
                    onValueChange = { email = it },
                    shape = RoundedCornerShape(27.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color.Black,
                        cursorColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(65.dp),
                    singleLine = true
                )
            }
            Spacer(Modifier.height(35.dp))
            Column {
                Button(
                    onClick = {
                        authWithGoogle.forgotPassword(email = email)
                            .onEach { response ->
                                when(response){
                                    is AuthState.SuccesResetPassword ->{
                                        Toast.makeText(context, "Please check your email", Toast.LENGTH_LONG).show()
                                    }
                                    is AuthState.Error -> {
                                        Toast.makeText(context, response.message, Toast.LENGTH_LONG).show()
                                    }
                                    else -> Unit
                                }
                            }
                            .launchIn(coroutineScope)
                    },
                    colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
                    modifier = Modifier
                        .width(180.dp)
                        .height(50.dp)
                ) {
                    Text(
                        text = stringResource(R.string.button_text_next)
                    )
                }
            }
        }
    }
}