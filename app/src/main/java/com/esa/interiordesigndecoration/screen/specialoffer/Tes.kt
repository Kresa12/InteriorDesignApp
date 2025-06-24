package com.esa.interiordesigndecoration.screen.specialoffer

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun Tes(viewModel: ProductViewModel = viewModel()) {

    val product = viewModel.product.collectAsState()

    CardProduct(
        product = product.value,
        onFetch = {viewModel.fetchProduct()}
    )

}