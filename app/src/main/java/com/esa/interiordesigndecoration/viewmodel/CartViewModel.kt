package com.esa.interiordesigndecoration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.local.cart.CartEntity
import com.esa.interiordesigndecoration.data.repository.CartRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartViewModel @Inject constructor(
    private val repository: CartRepository
) : ViewModel(){

    val cart : StateFlow<List<CartEntity?>> =
        repository.getAllCart()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun insert(cart : CartEntity){
        viewModelScope.launch {
            repository.insert(cart = cart)
        }
    }

    fun delete(cart : CartEntity){
        viewModelScope.launch {
            repository.delete(cart = cart)
        }
    }

    fun update(cart: CartEntity){
        viewModelScope.launch {
            repository.update(cart = cart)
        }
    }

    val subtotal: StateFlow<Float> = repository.subTotalPrice()
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0f)

    val tax: StateFlow<Float> = subtotal.map { it * 0.11f }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0f)

    val total: StateFlow<Float> = subtotal.map { it * 1.11f }
        .stateIn(viewModelScope, SharingStarted.WhileSubscribed(5000), 0f)

}
