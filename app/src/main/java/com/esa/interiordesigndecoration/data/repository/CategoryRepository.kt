package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.CategoryModel
import javax.inject.Inject

class CategoryRepository @Inject constructor(
    private val api : APIService
) {
    suspend fun getCategory() : List<CategoryModel>{
        return api.getCategory()
    }
}