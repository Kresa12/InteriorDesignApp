package com.esa.interiordesigndecoration.data.api

import com.esa.interiordesigndecoration.data.model.CategoryModel
import com.esa.interiordesigndecoration.data.model.ProductModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface APIService {
    @GET("Furniture/AllFurniture")
    suspend fun getProduct() : List<ProductModel>

    @GET("Furniture/{productId}")
    suspend fun getProductById(@Path("productId") productId : String) : ProductModel

    @GET("Category/AllCategories")
    suspend fun getCategory() : List<CategoryModel>

    @GET("Furniture/GetAllFurnisInCategoryByCategoryName")
    suspend fun getAllFurnishCategoryByCategoryName(@Query("category") categoryName : String) : List<ProductModel>
}
