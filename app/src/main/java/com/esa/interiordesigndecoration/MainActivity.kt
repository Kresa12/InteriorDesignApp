package com.esa.interiordesigndecoration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.component.BottomNavigationBar
import com.esa.interiordesigndecoration.data.model.ProductModel
import com.esa.interiordesigndecoration.ui.theme.InteriorDesignDecorationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            val bottomBarScreens = listOf(
                "homePage", "category", "wishList", "cart", "profile"
            )

            val showBottomBar = bottomBarScreens.any { currentRoute?.startsWith(it) == true }

            val selectedRoomIndex = remember { mutableIntStateOf(0) }

            val productWishList = remember { mutableListOf<ProductModel>() }
            InteriorDesignDecorationTheme {
                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigationBar(navController = navController, selectedRoom = selectedRoomIndex.value)
                        }
                    }
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        selectedRoomIndex = selectedRoomIndex,
                        productWishList = productWishList
                    )
                }
            }
        }
    }
}