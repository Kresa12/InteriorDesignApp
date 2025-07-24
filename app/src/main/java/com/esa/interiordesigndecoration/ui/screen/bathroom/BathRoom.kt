package com.esa.interiordesigndecoration.ui.screen.bathroom

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
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.ui.component.CardProductListByRoom
import com.esa.interiordesigndecoration.ui.component.Category
import com.esa.interiordesigndecoration.ui.component.TopBarHome
import com.esa.interiordesigndecoration.viewmodel.CartViewModel
import com.esa.interiordesigndecoration.viewmodel.WishlistViewModel

@Composable
fun BathRoom(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {},
    navigateToDetailProduct : (Int) -> Unit = {},
) {
    val selectedRoom by remember{ mutableStateOf("BathRoom") }
    var selectedCategory by remember { mutableStateOf("") }
    val viewModelProductWishList : WishlistViewModel = hiltViewModel()
    val viewModelCart : CartViewModel = hiltViewModel()

    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(10.dp))
        TopBarHome(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.topbar_bathroom_title)
        )
        Spacer(Modifier.height(25.dp))
        Category(onCategorySelected = {selectedCategory = it})
        Spacer(Modifier.height(35.dp))
        CardProductListByRoom(navigateToDetailProduct = navigateToDetailProduct ,selectedRoom = selectedRoom, selectedCategory = selectedCategory, viewModelProductWishList = viewModelProductWishList, viewModelCart = viewModelCart)
    }
}