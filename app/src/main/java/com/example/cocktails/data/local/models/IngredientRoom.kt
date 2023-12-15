package com.example.cocktails.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.Companion.CASCADE
import androidx.room.PrimaryKey

@Entity("ingredients", foreignKeys = [
    ForeignKey(CocktailRoom::class, parentColumns = arrayOf("id"), childColumns = arrayOf("cocktailId"), onDelete = CASCADE)
],
    primaryKeys = [
        "cocktailId", "name"
    ])
data class IngredientRoom (
    @ColumnInfo("cocktailId") val cocktailId: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("measure") val measure: String?
)
