package com.esa.interiordesigndecoration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.screen.specialoffer.DetailProductScrenn
import com.esa.interiordesigndecoration.screen.specialoffer.SpecialOfferScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()

            NavHost(navController = navController, startDestination = "product"){
                composable("product"){
                    SpecialOfferScreen(
                        navController = navController
                    )
                }
                composable("productDetail/{productId}"){backStackEntry ->
                    val productId = backStackEntry.arguments?.getString("productId")?.toIntOrNull()
                    if (productId != null){
                        DetailProductScrenn(
                            productId = productId,
                            onBackClicked = {navController.popBackStack()}
                        )
                    }
                }
            }
        }
    }
}