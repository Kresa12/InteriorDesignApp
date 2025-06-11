package com.esa.interiordesigndecoration

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.SIgnUp.SignUpScreen
import com.esa.interiordesigndecoration.screen.launch.LaunchScreenAndLoginSigUp
import com.esa.interiordesigndecoration.screen.login.LoginScreen
import com.esa.interiordesigndecoration.screen.splash.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "splash") {
        composable("splash"){ SplashScreen(navController = navController) }
        composable("launch"){ LaunchScreenAndLoginSigUp(navController = navController) }
        composable("login"){ LoginScreen(navController) }
        composable("signup"){ SignUpScreen(navController) }
    }

}