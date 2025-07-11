package com.esa.interiordesigndecoration.screen.onboarding

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowForward
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.data.model.OnBoardingModel
import kotlinx.coroutines.launch

@Composable
fun OnBoardingScreen(
    navController: NavController
) {
    val pages = listOf(
        OnBoardingModel.First,
        OnBoardingModel.Second,
        OnBoardingModel.Third,
        OnBoardingModel.Fourth
    )
    val pagerState = rememberPagerState(pageCount = { pages.size })
    val coroutineScope = rememberCoroutineScope()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        HorizontalPager(
            state = pagerState,
            verticalAlignment = Alignment.Top
        ) { position ->
            Box{
                OnBoardingPage(onBoarding = pages[position])
                Box(
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(top = 55.dp, end = 15.dp)
                ){
                    SkipButton(
                        modifier = Modifier
                            .width(55.dp),
                        pagerState = pagerState,
                        onClick = {
                            coroutineScope.launch {
                                pagerState.animateScrollToPage(
                                    when(pagerState.currentPage){
                                        0 -> pagerState.currentPage + 3
                                        1 -> pagerState.currentPage + 2
                                        2 -> pagerState.currentPage + 1
                                        else -> return@launch
                                    }
                                )
                            }
                        }
                    )
                }
            }
        }
        Spacer(Modifier.height(90.dp))
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 20.dp)
        ) {
            Row {
                repeat(pages.size) {
                    val isSelected = it == pagerState.currentPage
                    Box(
                        modifier = Modifier
                            .padding(4.dp)
                            .width(if (isSelected) 30.dp else 10.dp)
                            .height(5.dp)
                            .clip(CircleShape)
                            .background(if (isSelected) Color(0xFFF4B5A4) else Color(0xFFFAF0E6))
                            .clickable {
                                coroutineScope.launch {
                                    pagerState.animateScrollToPage(it)
                                }
                            }
                    )
                }
            }
            NextButton(
                modifier = Modifier
                    .width(140.dp)
                    .height(50.dp),
                pagerState = pagerState,
                onClick = {
                    coroutineScope.launch {
                        pagerState.animateScrollToPage(pagerState.currentPage + 1)
                    }
                    if (pagerState.currentPage == 3){
                        navController.navigate("launch"){
                            popUpTo(0)
                        }
                    }
                }
            )
        }
    }
}

@Composable
fun OnBoardingPage(onBoarding: OnBoardingModel) {
    Column(
        modifier = Modifier
            .background(Color.White)
    ) {
        Box(
            contentAlignment = Alignment.TopEnd,
            modifier = Modifier
                .fillMaxWidth()
                .clip(shape = RoundedCornerShape(bottomStart = 30.dp))
                .background(Color(0xFFFAF0E6))
        ) {
            Image(
                painter = painterResource(onBoarding.image),
                contentDescription = "",
                contentScale = ContentScale.FillBounds,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp)
                    .padding(bottom = 30.dp)
            )
        }
        Spacer(Modifier.height(45.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = onBoarding.titlePage,
                color = Color(0xFFF4B5A4),
                fontSize = 30.sp,
                fontWeight = FontWeight.SemiBold
            )
            Spacer(Modifier.height(13.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 25.dp)
            ) {
                Text(
                    text = onBoarding.descriptionPage,
                    textAlign = TextAlign.Center,
                    fontSize = 13.sp,
                    lineHeight = 16.sp
                )
            }
        }
    }
}


@Composable
fun SkipButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit = {}
) {
    AnimatedVisibility(
        visible = pagerState.currentPage != 3,
        modifier = modifier
            .clickable { onClick() }
    ) {
        Row (
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = modifier
        ){
            Text(
                text = "Skip",
                fontSize = 17.sp,
                fontWeight = FontWeight.W500
            )
            Icon(
                imageVector = Icons.AutoMirrored.Outlined.ArrowForward,
                contentDescription = "",
                modifier = Modifier
                    .size(18.dp)
            )
        }
    }
}

@Composable
fun NextButton(
    modifier: Modifier = Modifier,
    pagerState: PagerState,
    onClick: () -> Unit = {}
) {
    Button(
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(Color(0xFFF4B5A4))
    ) {
        if (pagerState.currentPage == 3){
            Text(
                text = "Get Started"
            )
        }else{
            Text(
                text = "Next"
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//private fun OnboardingScreenFistPrev() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        OnBoardingPage(onBoarding = OnBoardingModel.First)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun OnboardingScreenSecondPrev() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        OnBoardingPage(onBoarding = OnBoardingModel.Second)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun OnboardingScreenThirdPrev() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        OnBoardingPage(onBoarding = OnBoardingModel.Third)
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//private fun OnboardingScreenFourthPrev() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        OnBoardingPage(onBoarding = OnBoardingModel.Fourth)
//    }
//}

//@Preview(showBackground = true)
//@Composable
//private fun WelcomePrev() {
//    Column(
//        modifier = Modifier
//            .fillMaxSize()
//    ) {
//        OnBoardingScreen()
//    }
//}