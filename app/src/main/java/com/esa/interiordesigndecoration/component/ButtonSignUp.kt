package com.esa.interiordesigndecoration.component

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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.esa.interiordesigndecoration.R

@Composable
fun ButtonSignUp(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        Text(
            text = buildString {
                append(stringResource(R.string.by_continuing_you_agree_to))
                append(stringResource(R.string.terms_of_use_and_privacy_policy))
            },
            textAlign = TextAlign.Center
        )

        Spacer(Modifier.height(7.dp))
        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
            modifier = Modifier
                .width(180.dp)
                .height(50.dp)
        ) {
            Text(
                text = stringResource(R.string.signup_btn_sign_up)
            )
        }

    }
}