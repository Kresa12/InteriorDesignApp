package com.esa.interiordesigndecoration.data.model

import com.esa.interiordesigndecoration.R

data class OnBoardingModel(
    val image : Int,
    val titlePage : String,
    val descriptionPage : String
)

object OnBoardingObject{
    val onBoardingPageList = listOf(
        OnBoardingModel(R.drawable.onboarding1, "Confortable Space", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
        OnBoardingModel(R.drawable.onboarding2, "Modern Design", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
        OnBoardingModel(R.drawable.onboarding3, "Styled Living", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. "),
        OnBoardingModel(R.drawable.onboarding4, "Relaxing Furniture", "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. ")
    )
}