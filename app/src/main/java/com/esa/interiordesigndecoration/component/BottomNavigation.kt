package com.esa.interiordesigndecoration.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.data.model.BottomNavigationItemModel

@Composable
fun BottomNavigationBar(navController: NavController) {
    var itemNavigationSelected by remember { mutableIntStateOf(0) }

    BottomNavigation(
        backgroundColor = Color.White,
        elevation = 10.dp,
        modifier = Modifier
            .fillMaxWidth()
    ) {
        val bottomNavigationItem = listOf(
            BottomNavigationItemModel(
                icon = R.drawable.navigationhome,
                title = "Home"
            ),
            BottomNavigationItemModel(
                icon = R.drawable.navigationcategories,
                title = "Categories"
            ),
            BottomNavigationItemModel(
                icon = R.drawable.navigationcart,
                title = "Cart"
            ),
            BottomNavigationItemModel(
                icon = R.drawable.navigationwishlist,
                title = "Wish List"
            ),
            BottomNavigationItemModel(
                icon = R.drawable.navigationprofile,
                title = "Profile"
            )
        )
        bottomNavigationItem.forEachIndexed{index, item ->
            val isSelected = itemNavigationSelected == index
            BottomNavigationItem(
                selected = isSelected,
                onClick = {
                    itemNavigationSelected = index
                    when(itemNavigationSelected){
                        0 -> navController.navigate("homePage")
                        1 -> navController.navigate("category")
                        2 -> navController.navigate("cart")
                        3 -> navController.navigate("wishList")
                        4 -> navController.navigate("profile")
                    }
                },
                icon = {
                    Icon(
                        painter = painterResource(item.icon),
                        contentDescription = "",
                        tint = Color.Black,
                        modifier = Modifier
                            .size(17.dp)
                    )
                },
                label = {
                    Text(
                        text = "_",
                        color = if (isSelected) Color.White else Color.Black
                    )
                },
                alwaysShowLabel = isSelected
            )
        }
    }
}