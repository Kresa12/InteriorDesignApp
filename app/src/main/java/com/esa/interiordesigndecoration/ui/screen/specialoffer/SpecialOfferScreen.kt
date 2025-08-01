package com.esa.interiordesigndecoration.ui.screen.specialoffer

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.esa.interiordesigndecoration.ui.component.CardProductListAll
import com.esa.interiordesigndecoration.ui.component.Category
import com.esa.interiordesigndecoration.ui.component.TopBarHome

@Composable
fun SpecialOfferScreen(
    modifier: Modifier = Modifier,
    onBackClicked: () -> Unit = {},
    navigateToDetailProduct : (Int) -> Unit = {}
) {
    var selectedCategory by remember { mutableStateOf("All") }
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        Spacer(Modifier.height(10.dp))
        TopBarHome(onBackClicked = onBackClicked, topBarTitle = "Special Offer")
        Spacer(Modifier.height(25.dp))
        Category(onCategorySelected = {selectedCategory = it})
        Spacer(Modifier.height(35.dp))
        CardProductListAll(navigateToDetailProduct = navigateToDetailProduct, selectedCategory = selectedCategory)
    }
}