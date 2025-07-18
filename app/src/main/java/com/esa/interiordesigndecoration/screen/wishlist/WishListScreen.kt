package com.esa.interiordesigndecoration.screen.wishlist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.esa.interiordesigndecoration.data.model.ProductModel

@Composable
fun WishListScreen(
     modifier: Modifier = Modifier,
     productWishList : MutableList<ProductModel>
) {
    Column (
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ){
        Spacer(Modifier.height(50.dp))
        Text(
            text = "WishList Screen"
        )
       LazyColumn {
           items(productWishList){
               Row {
                   Text(
                       text = it.name
                   )
                   Text(
                       text = it.roomName
                   )
               }
           }
       }
    }
}