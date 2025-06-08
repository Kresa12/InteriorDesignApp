package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R

@Composable
fun LauchButtonLoginSigUp(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    Column(
        modifier = modifier
    ) {
        Button(
            onClick = {
                navController.navigate("login")
            },
            colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.btn_log_in_text),
                color = Color(0xFFCC7861)
            )
        }

        Button(
            onClick = {},
            colors = ButtonDefaults.buttonColors(Color(0xFFFAF0E6)),
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(R.string.btn_sig_up_text),
                color = Color(0xFFDCBEB6)
            )
        }
    }
}