package com.esa.interiordesigndecoration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.esa.interiordesigndecoration.data.viewmodel.ProductViewModel

@Composable
fun Tes(modifier: Modifier = Modifier,viewModel: ProductViewModel = viewModel()) {

    val data = viewModel.productByRoom.collectAsState()
    val dataValue = data.value
    val fetch = viewModel.getAllFurnishInRoomByRoomName("BedRoom")
    LaunchedEffect(Unit) {
        return@LaunchedEffect fetch
    }
    Column(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.White)
    ) {
        LazyColumn {
            items(dataValue){
                Text(
                    text = it.categoryName
                )
            }
        }
    }
}