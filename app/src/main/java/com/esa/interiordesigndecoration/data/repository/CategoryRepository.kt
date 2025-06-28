package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIClient
import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.CategoryModel

class CategoryRepository(private val api : APIService = APIClient.apiService) {
    suspend fun getCategory() : List<CategoryModel>{
        return api.getCategory()
    }
}