package com.esa.interiordesigndecoration.screen.specialoffer

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.model.ProductModel
import com.esa.interiordesigndecoration.data.repository.ProductRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository = ProductRepository()): ViewModel() {

    private val _product = MutableStateFlow<List<ProductModel>>(emptyList())
    val product : StateFlow<List<ProductModel>> = _product

    fun fetchProduct(){
        viewModelScope.launch {
            try {
                val result = repository.getProduct()
                _product.value = result
            }catch (e : Exception){
                e.printStackTrace()
            }

        }
    }
}