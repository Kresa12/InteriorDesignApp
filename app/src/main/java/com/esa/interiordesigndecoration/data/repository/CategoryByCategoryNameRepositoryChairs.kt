package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIClient
import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.CategoryByCategoryNameModelChairs

class CategoryByCategoryNameRepositoryChairs(private val api : APIService = APIClient.apiService) {
    suspend fun getCategoryChairs() : List<CategoryByCategoryNameModelChairs>{
        return api.getCategoryByCategoryNameChairs()
    }
}