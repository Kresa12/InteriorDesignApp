package com.esa.interiordesigndecoration.data.api

import com.esa.interiordesigndecoration.data.model.CategoryModel
import com.esa.interiordesigndecoration.data.model.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path

interface APIService {
    @GET("Furniture/AllFurniture")
    suspend fun getProduct() : List<ProductModel>

    @GET("Furniture/{productId}")
    suspend fun getProductById(@Path("productId") productId : String) : ProductModel

    @GET("Category/AllCategories")
    suspend fun getCategory() : List<CategoryModel>
}
