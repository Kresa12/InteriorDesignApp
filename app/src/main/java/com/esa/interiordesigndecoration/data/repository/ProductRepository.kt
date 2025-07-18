package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.api.APIService
import com.esa.interiordesigndecoration.data.model.ProductModel
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val api : APIService
) {

    suspend fun getProduct() : List<ProductModel>{
        return api.getProduct()
    }

    suspend fun getProductById(productId : String) : ProductModel{
        return api.getProductById(productId = productId)
    }

    suspend fun getAllFurnishCategoryByCategoryName(categoryName : String) : List<ProductModel>{
        return api.getAllFurnishCategoryByCategoryName(categoryName = categoryName)
    }

    suspend fun getAllFurnishInRoomByRoomName(roomName : String) : List<ProductModel>{
        return api.getAllFurnishInRoomByRoomName(roomName = roomName)
    }
}