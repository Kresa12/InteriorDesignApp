package com.esa.interiordesigndecoration.di

import android.content.Context
import androidx.room.Room
import com.esa.interiordesigndecoration.data.local.wishlist.AppDatabase
import com.esa.interiordesigndecoration.data.local.wishlist.WishlistDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) : AppDatabase {
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "interior_design_db"
        ).build()
    }

    @Provides
    @Singleton
    fun ProvideWishlistDao(db : AppDatabase): WishlistDao {
        return db.wishlistDao()
    }
}