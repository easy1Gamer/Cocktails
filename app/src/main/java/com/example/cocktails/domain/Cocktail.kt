package com.example.cocktails.domain

data class Cocktail (
    val id: String,
    val name: String,
    val src: String,
    val ingredients: List<Ingredient> = emptyList()
)

