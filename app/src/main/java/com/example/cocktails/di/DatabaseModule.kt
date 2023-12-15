package com.example.cocktails.di

import android.content.Context
import com.example.cocktails.data.local.MyDao
import com.example.cocktails.database.AppDataBase
import dagger.Module
import dagger.Provides

@Module
object DatabaseModule {

    @Provides
    fun provideAppDataBase (context: Context) : AppDataBase {
        return AppDataBase.getInstance(context)
    }

    @Provides
    fun provideCocktailDao (appDataBase: AppDataBase): MyDao {
        return appDataBase.cocktailDao()
    }
}