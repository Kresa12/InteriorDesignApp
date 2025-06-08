package com.esa.interiordesigndecoration.screen.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun LoginScreen() {

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "Ini halaman login"
        )
    }


}