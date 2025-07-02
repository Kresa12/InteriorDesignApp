package com.esa.interiordesigndecoration.screen.forgotpassword

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.TopBar

@Composable
fun ForgotPasswordScreen(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {},
    onClickButtonNext : () -> Unit = {}
    ) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(60.dp))


        TopBar(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.title_reset_password_screen),
            modifier = Modifier
                .width(310.dp)
                .padding(20.dp)
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
                    value = "",
                    onValueChange = { },
                    shape = RoundedCornerShape(27.dp),
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedContainerColor = Color.White,
                        unfocusedContainerColor = Color.White,
                        unfocusedBorderColor = Color.White,
                        focusedBorderColor = Color.White,
                        cursorColor = Color.Black
                    ),
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(45.dp),
                    singleLine = true
                )
            }

            Spacer(Modifier.height(35.dp))

            Column {
                Button(
                    onClick = {
                        onClickButtonNext()
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


@Preview
@Composable
private fun ForgotPrev() {
    ForgotPasswordScreen()
}