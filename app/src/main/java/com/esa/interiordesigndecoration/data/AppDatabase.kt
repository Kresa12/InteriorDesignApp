package com.esa.interiordesigndecoration.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.esa.interiordesigndecoration.data.local.cart.CartDao
import com.esa.interiordesigndecoration.data.local.cart.CartEntity
import com.esa.interiordesigndecoration.data.local.wishlist.WishlishEntity
import com.esa.interiordesigndecoration.data.local.wishlist.WishlistDao

@Database(entities = [WishlishEntity::class, CartEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishlistDao() : WishlistDao

    abstract fun cartDao() : CartDao
}