package com.esa.interiordesigndecoration

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.esa.interiordesigndecoration.ui.component.BottomNavigationBar
import com.esa.interiordesigndecoration.ui.theme.InteriorDesignDecorationTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Suppress("DEPRECATION")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        window.navigationBarColor = android.graphics.Color.WHITE
        setContent {
            val navController = rememberNavController()
            val currentBackStackEntry by navController.currentBackStackEntryAsState()
            val currentRoute = currentBackStackEntry?.destination?.route

            val bottomBarScreens = listOf(
                "homePage", "bedRoom", "kitchen", "livingRoom", "bathRoom", "wishList", "cart", "myProfile"
            )

            val showBottomBar = bottomBarScreens.any { currentRoute?.startsWith(it) == true }

            val selectedRoomIndex = remember { mutableIntStateOf(0) }

            InteriorDesignDecorationTheme {
                Scaffold(
                    bottomBar = {
                        if (showBottomBar) {
                            BottomNavigationBar(navController = navController, selectedRoom = selectedRoomIndex.intValue)
                        }
                    },
                ) { innerPadding ->
                    AppNavigation(
                        navController = navController,
                        modifier = Modifier.padding(innerPadding),
                        selectedRoomIndex = selectedRoomIndex
                    )
                }
            }
        }
    }
}