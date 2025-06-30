package com.esa.interiordesigndecoration.data.api

import com.esa.interiordesigndecoration.data.model.CategoryByCategoryNameModelChairs
import com.esa.interiordesigndecoration.data.repository.CategoryByCategoryNameRepositoryTables
import com.esa.interiordesigndecoration.data.model.CategoryModel
import com.esa.interiordesigndecoration.data.model.ProductModel
import retrofit2.http.GET

interface APIService {
    @GET("Furniture/AllFurniture")
    suspend fun getProduct() : List<ProductModel>

    @GET("Category/AllCategories")
    suspend fun getCategory() : List<CategoryModel>

    @GET("Furniture/GetAllFurnisInCategoryByCategoryName?category=${}")
    suspend fun getCategoryByCategoryNameChairs() : List<CategoryByCategoryNameModelChairs>

    fun disis(tes : String) : String{
        when(onCa)
    }
//
//    @GET("Furniture/GetAllFurnisInCategoryByCategoryName?category=Tables")
//    suspend fun getCategoryByCategoryNameTables() : List<CategoryByCategoryNameRepositoryTables>
}
