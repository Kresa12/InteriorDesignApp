package com.esa.interiordesigndecoration.screen.bedroom

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
import com.esa.interiordesigndecoration.component.CardProductListByRoom
import com.esa.interiordesigndecoration.component.Category
import com.esa.interiordesigndecoration.component.TopBarHome
import com.esa.interiordesigndecoration.data.model.ProductModel
import com.esa.interiordesigndecoration.data.viewmodel.WishlistViewModel

@Composable
fun BedRoomScreen(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {},
    navigateToDetailProduct : (Int) -> Unit = {}
) {
    val selectedRoom by remember{ mutableStateOf("BedRoom") }
    var selectedCategory by remember { mutableStateOf("") }
    val viewModelProductWishList : WishlistViewModel = hiltViewModel()
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(10.dp))
        TopBarHome(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.topbar_bed_room_title)
        )
        Spacer(Modifier.height(25.dp))
        Category(onCategorySelected = {selectedCategory = it})
        Spacer(Modifier.height(35.dp))
        CardProductListByRoom(navigateToDetailProduct = navigateToDetailProduct ,selectedRoom = selectedRoom, selectedCategory = selectedCategory, viewModelProductWishList = viewModelProductWishList)
    }
}