package com.esa.interiordesigndecoration.screen.livingroom

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
import com.esa.interiordesigndecoration.R
import com.esa.interiordesigndecoration.component.CardProductListByRoom
import com.esa.interiordesigndecoration.component.Category
import com.esa.interiordesigndecoration.component.TopBarHome
import com.esa.interiordesigndecoration.data.model.ProductModel

@Composable
fun LivingRoomScreen(
    modifier: Modifier = Modifier,
    onBackClicked : () -> Unit = {},
    navigateToDetailProduct : (Int) -> Unit = {},
    productWishList : MutableList<ProductModel>
) {
    val selectedRoom by remember{ mutableStateOf("LivingRoom") }
    var selectedCategory by remember { mutableStateOf("") }
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(60.dp))
        TopBarHome(
            onBackClicked = onBackClicked,
            topBarTitle = stringResource(R.string.topbar_living_room_title)
        )
        Spacer(Modifier.height(25.dp))
        Category(onCategorySelected = {selectedCategory = it})
        Spacer(Modifier.height(35.dp))
        CardProductListByRoom(navigateToDetailProduct = navigateToDetailProduct ,selectedRoom = selectedRoom, selectedCategory = selectedCategory, productWishList = productWishList)
    }
}