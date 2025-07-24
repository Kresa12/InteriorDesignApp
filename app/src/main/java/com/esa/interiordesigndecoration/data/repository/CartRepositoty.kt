package com.esa.interiordesigndecoration.data.repository

import com.esa.interiordesigndecoration.data.local.cart.CartDao
import com.esa.interiordesigndecoration.data.local.cart.CartEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class CartRepository @Inject constructor(
    private val dao: CartDao
) {
    fun getAllCart(): Flow<List<CartEntity?>> = dao.getAllCart()

    suspend fun insert(cart : CartEntity) = dao.insert(cart = cart)

    suspend fun delete(cart : CartEntity) = dao.delete(cart = cart)
}