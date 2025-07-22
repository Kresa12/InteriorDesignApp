package com.esa.interiordesigndecoration.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
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
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.interiordesigndecoration.R

@Composable
fun LoginFormUI(
    modifier: Modifier = Modifier,
    valueEmailUserName : String,
    onValueChangeEmailUserName : (String)-> Unit,
    valuePassword : String,
    onValueChangePassword : (String)-> Unit,
    passwordVisible : Boolean,
    passwordVisibleChange : ()->Unit
) {

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 60.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .width(313.dp)
        ){
            Text(
                text = stringResource(R.string.login_form_text_username_or_email),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueEmailUserName,
                onValueChange = onValueChangeEmailUserName,
                shape = RoundedCornerShape(27.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                ),
                singleLine = true,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
            )
        }

        Spacer(Modifier.height(10.dp))
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
                onValueChange = onValueChangePassword,
                shape = RoundedCornerShape(27.dp),
                visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
                trailingIcon = {
                    val icon = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff
                    val desc = if (passwordVisible) "Hide password" else "Show password"
                    IconButton(onClick = passwordVisibleChange) {
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
fun LoginForm(modifier: Modifier = Modifier) {

    var valueEmailUserName by remember { mutableStateOf("") }
    var valuePassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    LoginFormUI(
        valueEmailUserName = valueEmailUserName,
        onValueChangeEmailUserName = {valueEmailUserName = it},
        valuePassword = valuePassword,
        onValueChangePassword = {valuePassword = it},
        passwordVisible = passwordVisible,
        passwordVisibleChange = {passwordVisible = !passwordVisible}
    )
}