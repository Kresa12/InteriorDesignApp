package com.esa.interiordesigndecoration.data.db

import com.esa.interiordesigndecoration.data.model.ProductModel

fun ProductModel.toWishlistEntity() : WishlishEntity {
    return WishlishEntity(
        id = this.id,
        name = this.name,
        description = this.description,
        price = this.price,
        pictureUrl = this.pictureUrl
    )
}