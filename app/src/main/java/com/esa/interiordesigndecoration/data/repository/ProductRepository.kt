package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIClient
import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.ProductModel

class ProductRepository(private val api : APIService = APIClient.apiService) {

    suspend fun getProduct() : List<ProductModel>{
        return api.getProduct()
    }

    suspend fun getProductById(productId : String) : ProductModel{
        return api.getProductById(productId = productId)
    }

    suspend fun getAllFurnishCategoryByCategoryName(categoryName : String) : List<ProductModel>{
        return api.getAllFurnishCategoryByCategoryName(categoryName = categoryName)
    }
}