package com.esa.interiordesigndecoration.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.esa.interiordesigndecoration.data.model.CategoryModel
import com.esa.interiordesigndecoration.data.repository.CategoryRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(
    private val repository: CategoryRepository
): ViewModel() {

    private val _category = MutableStateFlow<List<CategoryModel>>(emptyList())
    val category : StateFlow<List<CategoryModel>> = _category.asStateFlow()
    init {
        fetchCategory()
    }
    fun fetchCategory(){
        viewModelScope.launch {
            try {
                val result = repository.getCategory()
                _category.value = result
            }catch (e : Exception){
                e.printStackTrace()
            }

        }
    }
}