package com.esa.interiordesigndecoration.screen.onboarding

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.esa.interiordesigndecoration.data.model.OnBoardingObject

@Composable
fun OnBoardingScreen() {
    val pagerState = rememberPagerState(pageCount = { OnBoardingObject.onBoardingPageList.size })
    val coroutineScope = rememberCoroutineScope()
    HorizontalPager(
        state = pagerState,
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) { page ->
        Column (
            modifier = Modifier
                .fillMaxSize()
        ){
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .background(Color(0xFFFAF0E6))
            ){
                Image(
                    painter = painterResource(id = OnBoardingObject.onBoardingPageList[0][page])
                )
            }
        }
    }

}

@Preview
@Composable
private fun OnboardingScreenPrev() {
    OnBoardingScreen()
}