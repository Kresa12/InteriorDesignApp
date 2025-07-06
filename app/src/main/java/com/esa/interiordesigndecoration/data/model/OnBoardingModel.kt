package com.esa.interiordesigndecoration.data.model

import androidx.annotation.DrawableRes
import com.esa.interiordesigndecoration.R

sealed class OnBoardingModel(
    @DrawableRes
    val image : Int,
    val titlePage : String,
    val descriptionPage : String
) {
    object First : OnBoardingModel(R.drawable.onboarding1, "Confortable Space", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
    object Second :  OnBoardingModel(R.drawable.onboarding2, "Modern Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
    object Third : OnBoardingModel(R.drawable.onboarding3, "Styled Living", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
    object Fourth : OnBoardingModel(R.drawable.onboarding4, "Relaxing Furniture", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
}