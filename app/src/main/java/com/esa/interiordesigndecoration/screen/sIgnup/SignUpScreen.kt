package com.esa.interiordesigndecoration.screen.sIgnup

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.component.ButtonSignUp
import com.esa.interiordesigndecoration.component.SignUpForm
import com.esa.interiordesigndecoration.component.SinUpWithFacebookAndGoogle
import com.esa.interiordesigndecoration.component.TopBarSignUp

@Composable
fun SignUpScreen(navController: NavController) {

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){

        Spacer(Modifier.height(60.dp))

        TopBarSignUp(
            navController = navController,
            modifier = Modifier
                .width(300.dp)
                .padding(start = 20.dp)
        )

        SignUpForm()

        Spacer(Modifier.height(20.dp))

        ButtonSignUp()

        Spacer(Modifier.height(15.dp))

        SinUpWithFacebookAndGoogle()

    }
}