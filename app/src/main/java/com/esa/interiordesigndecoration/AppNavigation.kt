package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.forgotpassword.ForgotPasswordScreen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.sIgnup.SignUpScreen
import com.esa.interiordesigndecoration.screen.setpassword.SetPasswordScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash"){ SplashScreen(navController = navController) }
        composable("launch"){ LaunchScreenAndLoginSigUp(navController = navController) }
        composable("login"){ LoginScreen(
            forgotPassword = {navController.navigate("forgotPassword")})
        }
        composable("signup"){ SignUpScreen(
            onBackClicked = { navController.popBackStack()})
        }
        composable("forgotPassword"){ ForgotPasswordScreen(
            onBackClicked = {navController.popBackStack()},
            onClickButtonNext = {}
        ) }
        composable("setPassword"){ SetPasswordScreen(
            onBackClicked = {navController.popBackStack()},
            onClickResetPasswordButton = {navController.navigate("login")}
        ) }
    }
}