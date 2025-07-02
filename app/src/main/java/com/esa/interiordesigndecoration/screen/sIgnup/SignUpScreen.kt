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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.ButtonSignUp
import com.esa.interiordesigndecoration.component.SignUpForm
import com.esa.interiordesigndecoration.component.SinUpWithFacebookAndGoogle
import com.esa.interiordesigndecoration.component.TopBar

@Composable
fun SignUpScreen(
    onBackClicked : () -> Unit = {}
) {
    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(60.dp))
        TopBar(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.topbar_text_create_account),
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

@Preview
@Composable
private fun SignUpScreenPrev() {
    SignUpScreen()
}