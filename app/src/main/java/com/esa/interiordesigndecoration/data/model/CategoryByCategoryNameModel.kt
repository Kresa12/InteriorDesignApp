package com.esa.interiordesigndecoration.data.model

data class CategoryByCategoryNameModel(
    val id : Int,
    val name : String,
    val description : String,
    val price : Float,
    val stockQuantity : Int,
    val pictureUrl : String,
    val categoryId : Int,
    val categoryName : String,
    val roomId : Int,
    val roomName : String
)
