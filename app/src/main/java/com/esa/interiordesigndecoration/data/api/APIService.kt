package com.esa.interiordesigndecoration.data.api

import com.esa.interiordesigndecoration.data.model.ProductModel
import retrofit2.http.GET

interface APIService {
    @GET("AllFurniture")
    suspend fun getProduct() : List<ProductModel>
}