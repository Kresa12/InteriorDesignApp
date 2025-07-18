package com.esa.interiordesigndecoration.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.model.ProductModel
import com.esa.interiordesigndecoration.data.repository.ProductRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProductViewModel @Inject constructor(
    private val repository: ProductRepository
): ViewModel() {

    private val _product = MutableStateFlow<List<ProductModel>>(emptyList())
    val product : StateFlow<List<ProductModel>> = _product

    private val _productDetail = MutableStateFlow<ProductModel?>(null)
    val productDetail : StateFlow<ProductModel?> = _productDetail

    private val _productByCategory = MutableStateFlow<List<ProductModel>>(emptyList())
    val productByCategory : StateFlow<List<ProductModel>> = _productByCategory

    private val _productByRoom = MutableStateFlow<List<ProductModel>>(emptyList())
    val productByRoom : StateFlow<List<ProductModel>> = _productByRoom

    private val _isLoading = MutableStateFlow(false)
    val isLoading : StateFlow<Boolean> = _isLoading

    init {
        fetchProduct()
    }
    private var hasFetched = false
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
    private val productDetailCache = mutableMapOf<String, ProductModel>()
    fun getProductByid(productId: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val cached = productDetailCache[productId]
                if (cached != null) {
                    _productDetail.value = cached
                } else {
                    val result = repository.getProductById(productId)
                    productDetailCache[productId] = result
                    _productDetail.value = result
                }
            } finally {
                _isLoading.value = false
            }
        }
    }
    private val categoryCache = mutableMapOf<String, List<ProductModel>>()
    fun getAllFurnishCategoryByCategoryName(categoryName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val cached = categoryCache[categoryName]
                if (cached != null) {
                    _productByCategory.value = cached
                } else {
                    val result = repository.getAllFurnishCategoryByCategoryName(categoryName)
                    categoryCache[categoryName] = result
                    _productByCategory.value = result
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }
    private val roomCache = mutableMapOf<String, List<ProductModel>>()
    fun getAllFurnishInRoomByRoomName(roomName: String) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val cached = roomCache[roomName]
                if (cached != null) {
                    _productByRoom.value = cached
                } else {
                    val result = repository.getAllFurnishInRoomByRoomName(roomName)
                    roomCache[roomName] = result
                    _productByRoom.value = result
                }
            } catch (e: Exception) {
                e.printStackTrace()
            } finally {
                _isLoading.value = false
            }
        }
    }

}