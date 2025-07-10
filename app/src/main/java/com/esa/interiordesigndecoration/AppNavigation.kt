package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.data.viewmodel.AuthViewModel
import com.esa.interiordesigndecoration.screen.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.forgotpassword.ForgotPasswordScreen
import com.esa.interiordesigndecoration.screen.homepage.HomePageScreen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.onboarding.OnBoardingScreen
import com.esa.interiordesigndecoration.screen.sIgnup.SignupScreen
import com.esa.interiordesigndecoration.screen.setpassword.SetPasswordScreen
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen

@Composable
fun AppNavigation(modifier: Modifier = Modifier, authViewModel: AuthViewModel) {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(
                navController = navController,
//                authViewModel = authViewModel
            )
        }
        composable("launch") {
            LaunchScreenAndLoginSigUp(
                navController = navController,
            )
        }
        composable("login") {
            LoginScreen(
//                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable("signup") {
            SignupScreen(
//            onBackClicked = { navController.popBackStack()},
                authViewModel = authViewModel,
                navController = navController
            )
        }
        composable("forgotPassword") {
            ForgotPasswordScreen(
                onBackClicked = { navController.popBackStack() },
                onClickButtonNext = {}
            )
        }
        composable("setPassword") {
            SetPasswordScreen(
                onBackClicked = { navController.popBackStack() },
                onClickResetPasswordButton = { navController.navigate("login") }
            )
        }
        composable("onBoarding") {
            OnBoardingScreen(
//                onClick = {
//                    navController.navigate("homePage"){
//                        popUpTo(0)
//                    }
//                },
                navController = navController,
                authViewModel = authViewModel
            )
        }
        composable("homePage") {
            HomePageScreen(navController = navController
            )
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