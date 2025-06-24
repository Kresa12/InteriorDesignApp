package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIClient
import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.ProductModel

class ProductRepository(private val api : APIService = APIClient.apiService) {

    suspend fun getProduct() : List<ProductModel>{
        return api.getProduct()
    }
}