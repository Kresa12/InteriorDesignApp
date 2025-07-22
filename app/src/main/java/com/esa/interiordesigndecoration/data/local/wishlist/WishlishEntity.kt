package com.esa.interiordesigndecoration.data.local.wishlist

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "wishlist")
data class WishlishEntity(
    @PrimaryKey
    val id : Int,
    val name : String,
    val description : String,
    val price : Float,
    val pictureUrl : String
)