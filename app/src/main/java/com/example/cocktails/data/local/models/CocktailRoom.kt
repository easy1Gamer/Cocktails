package com.example.cocktails.data.local.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity("cocktails")
data class CocktailRoom(
    @PrimaryKey val id: String,
    @ColumnInfo("name") val name: String,
    @ColumnInfo("imageLink") val src: String
)