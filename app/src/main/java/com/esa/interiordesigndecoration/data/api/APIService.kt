package com.esa.interiordesigndecoration.data.api

import com.esa.interiordesigndecoration.data.model.CategoryByCategoryNameModel
import com.esa.interiordesigndecoration.data.model.CategoryModel
import com.esa.interiordesigndecoration.data.model.ProductModel
import retrofit2.http.GET

interface APIService {
    @GET("Furniture/AllFurniture")
    suspend fun getProduct() : List<ProductModel>

    @GET("Category/AllCategories")
    suspend fun getCategory() : List<CategoryModel>


    //cari cara ketika pencet kategori bisa muncul product sesuai dengan categorynya
//
//    @GET("Furniture/GetAllFurnisInCategoryByCategoryName?category=")
//    suspend fun getCategoryByCategoryName() : List<CategoryByCategoryNameModel>
}