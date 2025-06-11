package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.interiordesigndecoration.R
import com.google.type.Date
import java.text.SimpleDateFormat
import java.util.Locale

@Composable
fun SignFormUI(
    modifier: Modifier = Modifier,
    valueFullName : String,
    onValueChangeFullName : (String)-> Unit,
    valueEmail: String,
    onValueChangeEmail: (String)->Unit,
    isEmailValid: Boolean,
    valueMobileNumber: String,
    onValueChangeMobileNumber: (String)->Unit,
    valueDateOfBirth: String,
    onDateClick: () -> Unit,
    valuePassword : String,
    onValueChangePassword : (String)-> Unit,
    passwordVisible : Boolean,
    passwordVisibleChange : ()->Unit
) {

    Column (
        modifier = modifier
            .fillMaxWidth()
            .padding(top = 20.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Column(
            modifier = Modifier
                .width(313.dp)
        ){
            Text(
                text = stringResource(R.string.signup_text_full_name),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueFullName,
                onValueChange = onValueChangeFullName,
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

        Column(
            modifier = Modifier
                .width(313.dp)
        ) {
            Text(
                text = stringResource(R.string.signup_text_email),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueEmail,
                onValueChange = onValueChangeEmail,
                isError = !isEmailValid && valueEmail.isNotEmpty(),
                shape = RoundedCornerShape(27.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                    focusedBorderColor = if (isEmailValid || valueEmail.isEmpty()) Color(0xFFFAF0E6) else Color.Red,
                    cursorColor = Color.Black,
                    errorBorderColor = Color.Red,
                    errorContainerColor = Color(0xFFFFEDED)
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp),
                singleLine = true
            )

            if (!isEmailValid && valueEmail.isNotEmpty()) {
                Text(
                    text = "Email tidak valid",
                    color = Color.Red,
                    fontSize = 12.sp,
                    modifier = Modifier.padding(start = 8.dp, top = 4.dp)
                )
            }
        }


        Spacer(Modifier.height(10.dp))

        Column (
            modifier = Modifier
                .width(313.dp)
        ){
            Text(
                text = stringResource(R.string.signup_text_mobile_number),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueMobileNumber,
                onValueChange = onValueChangeMobileNumber,
                shape = RoundedCornerShape(27.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
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
                text = stringResource(R.string.signup_text_date_of_birth),
                fontSize = 17.sp
            )

            Spacer(Modifier.height(5.dp))

            OutlinedTextField(
                value = valueDateOfBirth,
                onValueChange = {},
                readOnly = true,
                shape = RoundedCornerShape(27.dp),
                colors = OutlinedTextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedContainerColor = Color(0xFFFAF0E6),
                    unfocusedBorderColor = Color(0xFFFAF0E6),
                    focusedBorderColor = Color(0xFFFAF0E6),
                    cursorColor = Color.Black
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(45.dp)
                    .clickable { onDateClick() },
                singleLine = true
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpForm(modifier: Modifier = Modifier) {

    var valueFullName by remember { mutableStateOf("") }
    var valueEmail by remember { mutableStateOf("") }
    val emailRegex = Regex("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")
    val isEmailValid = emailRegex.matches(valueEmail)
    var valueMobileNumber by remember { mutableStateOf("") }
    val numberRegex = Regex("[^0-9]")
    var valueDateOfBirth by remember { mutableStateOf("") }
    val datePickerState = rememberDatePickerState()
    var showDatePicker by remember { mutableStateOf(false) }
    val formatter = remember { SimpleDateFormat("dd MMM yyyy", Locale.getDefault()) }

    var valuePassword by remember { mutableStateOf("") }
    var passwordVisible by remember { mutableStateOf(false) }

    LaunchedEffect(datePickerState.selectedDateMillis) {
        datePickerState.selectedDateMillis?.let { millis ->
            valueDateOfBirth = formatter.format(java.util.Date(millis))
            showDatePicker = false
        }
    }

    //besok cari cara agar caleder bisa kebuka di hp

    if (showDatePicker) {
        DatePickerDialog(
            onDismissRequest = { showDatePicker = false },
            confirmButton = {
                TextButton(
                    onClick = { showDatePicker = false }
                ) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDatePicker = false }) {
                    Text("Batal")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }

    SignFormUI(
        valueFullName = valueFullName,
        onValueChangeFullName = {valueFullName = it},
        valueEmail = valueEmail,
        onValueChangeEmail = { valueEmail = it},
        isEmailValid = isEmailValid,
        valueMobileNumber = valueMobileNumber,
        onValueChangeMobileNumber = {
            val stripped = numberRegex.replace(it,"")
            valueMobileNumber = if (stripped.length >= 12){
                stripped.substring(0..9)
            }else{
                stripped
            }
        },
        valueDateOfBirth = valueDateOfBirth,
        onDateClick = {showDatePicker = true},
        valuePassword = valuePassword,
        onValueChangePassword = {valuePassword = it},
        passwordVisible = passwordVisible,
        passwordVisibleChange = {passwordVisible = !passwordVisible}
    )
}