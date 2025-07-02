package com.esa.interiordesigndecoration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.bedroom.BedRoomScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
//            val navController = rememberNavController()
//
//            NavHost(navController = navController, startDestination = "bedRoom") {
//                composable("bedRoom"){ BedRoomScreen(
//                    onBackClicked = {navController.popBackStack()}
//                ) }
//            }
            Tes()
//            AppNavigation()
        }
    }
}