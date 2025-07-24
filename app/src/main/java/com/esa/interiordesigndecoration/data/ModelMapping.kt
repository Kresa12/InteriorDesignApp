package com.esa.interiordesigndecoration.data

import com.esa.interiordesigndecoration.data.local.cart.CartEntity
import com.esa.interiordesigndecoration.data.local.wishlist.WishlishEntity
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

fun ProductModel.toCartEntity(): CartEntity {
    return CartEntity(
        id = this.id,
        name = this.name,
        price = this.price,
        pictureUrl = this.pictureUrl
    )
}