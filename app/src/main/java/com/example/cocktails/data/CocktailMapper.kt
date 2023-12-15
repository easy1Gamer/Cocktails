package com.example.cocktails.data

import com.example.cocktails.data.data.remote.DrinkRemote
import com.example.cocktails.data.local.models.CocktailRoom
import com.example.cocktails.data.local.models.IngredientRoom
import com.example.cocktails.domain.Cocktail
import com.example.cocktails.domain.Ingredient

fun CocktailRoom.asDomain(): Cocktail {
    return Cocktail(
        id = id,
        name = name,
        src = src
    )
}

fun Cocktail.asRoom(): CocktailRoom {
    return CocktailRoom(
        id = id,
        name = name,
        src = src
    )
}

fun Ingredient.asRoom(cocktailId: String): IngredientRoom {
    return IngredientRoom(
        cocktailId = cocktailId,
        name = name,
        measure = measure
    )
}

fun IngredientRoom.asDomain(): Ingredient {
    return Ingredient(
        name = name,
        measure = measure
    )
}

fun DrinkRemote.asDomain(): Cocktail {
    return Cocktail(
        id = idDrink,
        name = strDrink,
        src = strDrinkThumb,
        ingredients = this.mapIngredients()
    )
}

fun DrinkRemote.mapIngredients(): List<Ingredient> {
    val items = mutableListOf<Ingredient>()
    if (strIngredient1 != null) {
        items += Ingredient(strIngredient1, strMeasure1)
    }

    if (strIngredient2 != null) {
        items += Ingredient(strIngredient2, strMeasure2)
    }

    if (strIngredient3 != null) {
        items += Ingredient(strIngredient3, strMeasure3)
    }

    if (strIngredient4 != null) {
        items += Ingredient(strIngredient4, strMeasure4)
    }

    if (strIngredient5!= null) {
        items += Ingredient(strIngredient5, strMeasure5)
    }

    if (strIngredient6 != null) {
        items += Ingredient(strIngredient6, strMeasure6)
    }

    if (strIngredient7 != null) {
        items += Ingredient(strIngredient7, strMeasure7)
    }

    if (strIngredient8 != null) {
        items += Ingredient(strIngredient8, strMeasure8)
    }

    if (strIngredient9 != null) {
        items += Ingredient(strIngredient9, strMeasure9)
    }

    if (strIngredient10 != null) {
        items += Ingredient(strIngredient10, strMeasure10)
    }

    if (strIngredient11!= null) {
        items += Ingredient(strIngredient11, strMeasure11)
    }

    if (strIngredient12 != null) {
        items += Ingredient(strIngredient12, strMeasure12)
    }

    if (strIngredient13 != null) {
        items += Ingredient(strIngredient13, strMeasure13)
    }

    if (strIngredient14 != null) {
        items += Ingredient(strIngredient14, strMeasure14)
    }

    if (strIngredient15 != null) {
        items += Ingredient(strIngredient15, strMeasure15)
    }

    return items
}