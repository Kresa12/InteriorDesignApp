package com.esa.interiordesigndecoration.data.viewmodel

import androidx.lifecycle.ViewModel
import com.esa.interiordesigndecoration.data.model.ProductModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class WishListViewModel: ViewModel() {
    private val _productWishLish = MutableStateFlow<List<ProductModel>>(emptyList())
    val product : StateFlow<List<ProductModel>> = _productWishLish

    init {
        fetchProductWish()
    }
    fun fetchProductWish(){
        _productWishLish.value
    }
}