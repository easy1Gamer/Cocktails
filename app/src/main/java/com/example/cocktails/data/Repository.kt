package com.example.cocktails.data

import com.example.cocktails.domain.Cocktail
import com.example.cocktails.domain.Ingredient

interface Repository {

    fun getCocktailsByName(query: String, onFailure: (String) -> Unit, onSuccess: (List<Cocktail>) -> Unit)

    fun getCocktailById(query: String, onFailure: (String) -> Unit, onSuccess: (Cocktail) -> Unit)

    fun getCocktails(): List<Cocktail>

    fun insertCocktails(cocktails: List<Cocktail>)

    fun insertIngredients(ingredients: List<Ingredient>, cocktailId: String)

    fun update(cocktail: Cocktail)

    fun getLocalCocktailById(cocktailId: String): Cocktail

    fun deleteCache()

}