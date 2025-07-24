package com.esa.interiordesigndecoration.data.local.cart

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cart")
data class CartEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    val price : Float,
    val pictureUrl : String,
    val quantity : Int
)
