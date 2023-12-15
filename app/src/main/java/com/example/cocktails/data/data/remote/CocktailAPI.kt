package com.example.cocktails.data.data.remote


import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface CocktailAPI {
    @GET("api/json/v1/1/search.php")
    fun getByName(@Query("s") query: String) : Call<DrinksRemote>

    @GET("api/json/v1/1/lookup.php")
    fun getById(@Query("i") query: String) : Call<DrinksRemote>
}