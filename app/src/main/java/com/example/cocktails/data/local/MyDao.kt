package com.example.cocktails.data.local

import androidx.annotation.WorkerThread
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.example.cocktails.data.local.models.CocktailIngredientRoom
import com.example.cocktails.data.local.models.CocktailRoom
import com.example.cocktails.data.local.models.IngredientRoom
import com.example.cocktails.domain.Ingredient
import retrofit2.http.DELETE

@Dao
interface MyDao {
    @Query("SELECT * FROM cocktails")
    fun getAll(): List<CocktailRoom>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllCocktails(cocktails: List<CocktailRoom>)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllIngredients(ingredients: List<IngredientRoom>)

    @Update
    fun update(cocktail: CocktailRoom)

    @Query("SELECT * FROM cocktails WHERE id = :cocktailId")
    fun getCocktailById(cocktailId: String): CocktailIngredientRoom

    @Query("DELETE FROM cocktails")
    fun clearAllTables()
}