package com.esa.interiordesigndecoration.component

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.data.model.BottomNavigationItemModel

@Composable
fun BottomNavigation(
    modifier: Modifier = Modifier
) {
    val bottomNavigationItemModel = listOf(
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
            title = "Wist List"
        ),
        BottomNavigationItemModel(
            icon = R.drawable.navigationprofile,
            title = "Profile"
        )
    )
}