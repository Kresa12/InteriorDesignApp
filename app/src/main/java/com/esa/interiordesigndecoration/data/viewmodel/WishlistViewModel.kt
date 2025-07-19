package com.esa.interiordesigndecoration.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.db.WishlishEntity
import com.esa.interiordesigndecoration.data.repository.WishlistRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WishlistViewModel @Inject constructor(
    private val repository: WishlistRepository
) : ViewModel(){

    val productWishlist : StateFlow<List<WishlishEntity?>> =
        repository.getWishlist()
            .stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(5000),
                initialValue = emptyList()
            )

    fun insert(product : WishlishEntity){
        viewModelScope.launch {
            repository.insert(product)
        }
    }

    fun delete(product: WishlishEntity){
        viewModelScope.launch {
            repository.delete(product)
        }
    }
}