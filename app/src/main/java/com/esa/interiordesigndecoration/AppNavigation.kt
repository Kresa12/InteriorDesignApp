package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.forgotpassword.ForgotPasswordScreen
import com.esa.interiordesigndecoration.screen.sIgnup.SignUpScreen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.setpassword.SetPasswordScreen
import com.esa.interiordesigndecoration.screen.specialoffer.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash"){ SplashScreen(navController = navController) }
        composable("launch"){ LaunchScreenAndLoginSigUp(navController = navController) }
        composable("login"){ LoginScreen(navController) }
        composable("signup"){ SignUpScreen(navController) }
        composable("forgotPassword"){ ForgotPasswordScreen(navController = navController) }
        composable("setPassword"){ SetPasswordScreen(
            onBackClicked = {navController.popBackStack()},
            onClickResetPasswordButton = {navController.navigate("login")}
        ) }

//        composable("product"){
//            SpecialOfferScreen(
//                navController = navController
//            )
//        }
//        composable("productDetail/{productId}"){backStackEntry ->
//            val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
//            if (productId != null){
//                DetailProductScrenn(
//                    productId = productId,
//                    onBackClicked = {navController.popBackStack()}
//                )
//            }
//        }
        //besok benerin masalah navController dulu ya, buka gpt
    }

}