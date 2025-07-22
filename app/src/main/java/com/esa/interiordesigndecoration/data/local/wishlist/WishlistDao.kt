package com.esa.interiordesigndecoration.data.local.wishlist

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface WishlistDao {

    @Query("SELECT * FROM wishlist")
    fun getWishlist(): Flow<List<WishlishEntity?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(product : WishlishEntity)

    @Delete
    suspend fun delete(product : WishlishEntity)
}