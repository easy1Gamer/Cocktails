package com.example.cocktails.di

import com.example.cocktails.data.data.remote.CocktailAPI
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
object ApiModule {

    @Provides
    fun provideCocktailApi(httpClient : Retrofit) : CocktailAPI {
        return httpClient.create(CocktailAPI::class.java)
    }

    @Provides
    fun provideHttpClient() : Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://www.thecocktaildb.com/")
            .build()
    }
}