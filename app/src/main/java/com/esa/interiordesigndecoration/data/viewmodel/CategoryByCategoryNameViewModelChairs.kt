package com.esa.interiordesigndecoration.data.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.model.CategoryByCategoryNameModelChairs
import com.esa.interiordesigndecoration.data.repository.CategoryByCategoryNameRepositoryChairs
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CategoryByCategoryNameViewModelChairs(private val repository: CategoryByCategoryNameRepositoryChairs) : ViewModel() {
    private val _categoryChairs = MutableStateFlow<List<CategoryByCategoryNameModelChairs>>(emptyList())
    val categoryChairs : StateFlow<List<CategoryByCategoryNameModelChairs>> = _categoryChairs

    init {
        fetchCategoryChairs()
    }

    fun fetchCategoryChairs(){
        viewModelScope.launch {
            try {
                delay(2000)
                val result = repository.getCategoryChairs()
                _categoryChairs.value = result
            }catch (e : Exception){
                e.printStackTrace()
            }
        }
    }
}