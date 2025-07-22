package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.local.wishlist.WishlishEntity
import com.esa.interiordesigndecoration.data.local.wishlist.WishlistDao
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class WishlistRepository @Inject constructor(
    private val dao: WishlistDao
) {
    fun getWishlist():Flow<List<WishlishEntity?>> = dao.getWishlist()

    suspend fun insert(product : WishlishEntity) = dao.insert(product)

    suspend fun delete(product: WishlishEntity)= dao.delete(product)
}