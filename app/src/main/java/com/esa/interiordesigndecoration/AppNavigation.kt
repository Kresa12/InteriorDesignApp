package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.esa.interiordesigndecoration.screen.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.forgotpassword.ForgotPasswordScreen
import com.esa.interiordesigndecoration.screen.homepage.HomePageScreen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.onboarding.OnBoardingScreen
import com.esa.interiordesigndecoration.screen.sIgnup.SignupScreen
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen
import com.esa.interiordesigndecoration.ui.CategoryTesScreen
import com.esa.interiordesigndecoration.ui.WhistListTesScreen

@Composable
fun AppNavigation(navController: NavHostController, modifier: Modifier = Modifier) {

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                navController = navController
            )
        }
        composable("launch") {
            LaunchScreenAndLoginSigUp(
                navController = navController,
            )
        }
        composable("login") {
            LoginScreen(
                navController = navController
            )
        }
        composable("signup") {
            SignupScreen(
                navController = navController
            )
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(
                navController = navController
            )
        }
        composable("onBoarding") {
            OnBoardingScreen(
                navController = navController
            )
        }
        composable("homePage") {
            HomePageScreen(
                navController = navController
            )
        }
        composable("category") {
            CategoryTesScreen()
        }
        composable("wishList") {
            WhistListTesScreen()
        }
        composable("product") {
            SpecialOfferScreen(
                onBackClicked = {},
                navigateToDetailProduct = { navController.navigate("productDetail/${it}") }
            )
        }
        composable("productDetail/{productId}") { backStackEntry ->
            val productId = backStackEntry.arguments?.getString("productId") ?: ""
            DetailProductScrenn(
                productId = productId,
                onBackClicked = { navController.popBackStack() }
            )
        }
    }
}