package com.example.cocktails.data.local.models

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation
import com.example.cocktails.domain.Cocktail

@Entity("cocktailIngredients")
class CocktailIngredientRoom (
    @Embedded val cocktail: CocktailRoom,
    @Relation(
        parentColumn = "id",
        entityColumn = "cocktailId"
    )
    val ingredients: List<IngredientRoom>
)