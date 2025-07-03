package com.esa.interiordesigndecoration

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
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
        Spacer(Modifier.height(100.dp))
        Text(
            text = "jhkjhkuhu"
        )
        LazyColumn(
            modifier = Modifier
                .background(Color.Green)
        ) {
            items(dataValue){
                Text(
                    text = it.categoryName
                )
            }
        }
    }
}