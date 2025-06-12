package com.esa.interiordesigndecoration.screen.setpassword

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
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.TopBarSetPassword

@Composable
fun SetPasswordScreen(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {},
    onClickResetPasswordButton : () -> Unit = {}
) {

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        Spacer(Modifier.height(60.dp))

        TopBarSetPassword(
        onBackClicked = onBackClicked,
            modifier = Modifier
                .width(230.dp)
        )

        Spacer(Modifier.height(20.dp))

        Text(
            text = stringResource(R.string.change_the_password),
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

        SetPasswordForm()

        Spacer(Modifier.height(35.dp))

        ButtonSetPassword(onClickResetPasswordButton = onClickResetPasswordButton)
    }
}

@Composable
fun SetPasswordForm(modifier: Modifier = Modifier) {

    var valuePassword by remember { mutableStateOf("") }
    var valueConfirmPassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ){
        Column (
            modifier = Modifier
                .width(313.dp)
        ){
            Text(
                text = stringResource(R.string.password_text_login),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valuePassword,
                onValueChange = {valuePassword = it},
                shape = RoundedCornerShape(27.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val desc = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = {passwordVisible = !passwordVisible}) {
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
                    focusedBorderColor = Color(0xFFFAF0E6),
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                singleLine = true
            )
        }

        Spacer(Modifier.height(10.dp))

        Column (
            modifier = Modifier
                .width(313.dp)
        ){
            Text(
                text = stringResource(R.string.signup_text_confirm_password),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueConfirmPassword,
                onValueChange = {valueConfirmPassword = it},
                shape = RoundedCornerShape(27.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
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
                    focusedBorderColor = Color(0xFFFAF0E6),
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                singleLine = true
            )
        }
    }
}

@Composable
fun ButtonSetPassword(
    modifier: Modifier = Modifier,
    onClickResetPasswordButton : () -> Unit = {}
) {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier
            .fillMaxWidth()
    ) {
        Button(
            onClick = {
                onClickResetPasswordButton()
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
            modifier = Modifier
                .width(180.dp)
                .height(50.dp)
        ) {
            Text(
                text = stringResource(R.string.reset_password_text_btn),
                color = Color(0xFFCC7861)
            )
        }
    }
}

@Preview
@Composable
private fun PrevSet() {
    SetPasswordScreen()
}