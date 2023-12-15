package com.example.cocktails.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.cocktails.data.local.MyDao
import com.example.cocktails.data.local.models.CocktailRoom
import com.example.cocktails.data.local.models.IngredientRoom

@Database(
    version = 1,
    entities = [CocktailRoom::class, IngredientRoom::class]
)

abstract class AppDataBase : RoomDatabase() {

    abstract fun cocktailDao(): MyDao

    companion object {
        private var INSTANCE: AppDataBase? = null

        fun getInstance(context: Context): AppDataBase {
            if (INSTANCE == null) {
                synchronized(AppDataBase::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        AppDataBase::class.java, "database"
                    )
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE!!
        }
    }
}