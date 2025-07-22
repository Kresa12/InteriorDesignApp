package com.esa.interiordesigndecoration.data.local.wishlist

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [WishlishEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun wishlistDao() : WishlistDao
}