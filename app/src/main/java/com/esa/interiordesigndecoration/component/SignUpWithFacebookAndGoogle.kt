package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.esa.interiordesigndecoration.R

@Composable
fun SinUpWithFacebookAndGoogle(modifier: Modifier = Modifier) {

    Column (
        modifier = modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text(
            text = stringResource(R.string.or_sign_up_with),
            color = Color.Gray,

        )

        Spacer(Modifier.height(15.dp))

        Row {
            Image(
                painter = painterResource(R.drawable.facebookicon),
                contentDescription = "facebook icon",
                modifier = Modifier
                    .size(40.dp)
            )

            Spacer(Modifier.width(20.dp))

            Image(
                painter = painterResource(R.drawable.googleicon),
                contentDescription = "google icon",
                modifier = Modifier
                    .size(40.dp)
            )
        }

        Spacer(Modifier.height(30.dp))

        Row {
            Text(
                text = stringResource(R.string.don_t_have_an_account),
                color = Color.Gray,
            )

            Spacer(Modifier.width(5.dp))

            Text(
                text = stringResource(R.string.sign_up_dialogue),
                color = Color(0xFFCC7861),
            )
        }
    }
}