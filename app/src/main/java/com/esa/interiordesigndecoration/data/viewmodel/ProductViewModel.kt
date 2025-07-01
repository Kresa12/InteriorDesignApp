package com.esa.interiordesigndecoration.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.model.ProductModel
import com.esa.interiordesigndecoration.data.repository.ProductRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ProductViewModel(private val repository: ProductRepository = ProductRepository()): ViewModel() {
    private val _product = MutableStateFlow<List<ProductModel>>(emptyList())
    val product : StateFlow<List<ProductModel>> = _product
    private val _productDetail = MutableStateFlow<ProductModel?>(null)
    val productDetail : StateFlow<ProductModel?> = _productDetail
    private val _isLoading = MutableStateFlow(false)
    val isLoading : StateFlow<Boolean> = _isLoading
    private var hasFetched = false
    init {
        fetchProduct()
    }
    fun fetchProduct(){
        if (hasFetched) return
        viewModelScope.launch {
            try {
                _isLoading.value = true
                delay(5000)
                val result = repository.getProduct()
                _product.value = result
                hasFetched = true
            }catch (e : Exception){
                e.printStackTrace()
            }finally {
                _isLoading.value = false
            }
        }
    }

    fun getProductByid(productId : String){
        if (hasFetched) return
        viewModelScope.launch {
            try {
                _isLoading.value = true
//                delay(5000)
                val result = repository.getProductById(productId = productId)
                _productDetail.value = result
                hasFetched = true
            }catch (e : Exception){
                e.printStackTrace()
            }finally {
                _isLoading.value = false
            }
        }
    }
}