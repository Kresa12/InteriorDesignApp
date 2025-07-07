package com.esa.interiordesigndecoration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.bedroom.BedRoomScreen
import com.esa.interiordesigndecoration.screen.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.bathroom.BathRoom
import com.esa.interiordesigndecoration.screen.homepage.HomePageScreen
import com.esa.interiordesigndecoration.screen.kitchenroom.Kitchen
import com.esa.interiordesigndecoration.screen.livingroom.LivingRoomScreen
import com.esa.interiordesigndecoration.screen.onboarding.OnBoardingScreen
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen
import com.google.firebase.Firebase
import com.google.firebase.auth.auth

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val auth = Firebase.auth
        setContent {
            val navController = rememberNavController()
//
            NavHost(navController = navController, startDestination = "onBoarding") {
//                composable("bedRoom"){ BedRoomScreen(
//                    onBackClicked = {navController.popBackStack()},
//                    navigateToDetailProduct = {navController.navigate("productDetail/${it}")}
//                ) }
//                composable("livingRoom") {
//                    LivingRoomScreen(
//                        onBackClicked = {},
//                        navigateToDetailProduct = {navController.navigate("productDetail/${it}")}
//                    )
//                }
//                composable("kitchen") {
//                    Kitchen(
//                        onBackClicked = {},
//                        navigateToDetailProduct = {navController.navigate("productDetail/${it}")}
//                    )
//                }
//                composable("bathroom") {
//                    BathRoom(
//                        onBackClicked = {},
//                        navigateToDetailProduct = {navController.navigate("productDetail/${it}")}
//                    )
//                }
//                composable("product") {
//                    SpecialOfferScreen(
//                        onBackClicked = {},
//                        navigateToDetailProduct = {navController.navigate("productDetail/${it}")}
//                    )
//                }
//                composable("productDetail/{productId}") { backStackEntry ->
//                    val productId = backStackEntry.arguments?.getString("productId") ?: ""
//                    DetailProductScrenn(
//                        productId = productId,
//                        onBackClicked = { navController.popBackStack() }
//                    )
//                }
                composable("onBoarding"){ OnBoardingScreen(
                    onClick = {navController.navigate("homePage")}
                ) }
                composable("homePage"){ HomePageScreen(

                ) }
            }
//            Tes()
//            AppNavigation()
//            OnBoardingScreen()
        }
    }
}