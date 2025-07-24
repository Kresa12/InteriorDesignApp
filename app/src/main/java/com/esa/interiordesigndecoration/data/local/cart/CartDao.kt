package com.esa.interiordesigndecoration.data.local.cart

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow

@Dao
interface CartDao {

    @Query("SELECT * FROM cart")
    fun getAllCart(): Flow<List<CartEntity?>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(cart : CartEntity)

    @Delete
    suspend fun delete(cart : CartEntity)

    @Update
    suspend fun update(cart: CartEntity)

    @Query("SELECT SUM(price * quantity) FROM cart")
    fun subTotalPrice(): Flow<Float>
}