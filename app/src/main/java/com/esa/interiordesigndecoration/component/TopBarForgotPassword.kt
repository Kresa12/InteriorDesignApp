package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R

@Composable
fun TopBarForgotPassword(
    modifier: Modifier = Modifier,
//    navController : NavController
    ) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ){
        Icon(
            imageVector = Icons.Outlined.ArrowBack,
            contentDescription = "",
            modifier = Modifier
                .size(35.dp)
                .clickable {
//                    navController.popBackStack()
                }
        )

        Text(
            text = stringResource(R.string.forgot_password_text),
            color = Color(0xFFF4B5A4),
            fontSize = 27.sp,
            fontWeight = FontWeight.Bold
        )
    }
}