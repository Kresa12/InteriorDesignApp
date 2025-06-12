package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R

@Composable
fun ButtonLoginAndForgetPasswordUI(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column (
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Button(
            onClick = { },
            colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
            modifier = Modifier
                .width(180.dp)
                .height(50.dp)
        ) {
            Text(
                text = stringResource(R.string.login_button_text)
            )
        }

        Spacer(Modifier.height(15.dp))

        Text(
            text = stringResource(R.string.forget_password_text),
            modifier = Modifier
                .clickable {
                    navController.navigate("forgotPassword")
                }
        )
    }
}