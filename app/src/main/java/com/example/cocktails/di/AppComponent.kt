package com.example.cocktails.di

import android.content.Context
import com.example.cocktails.presentation.MainActivityViewModel
import com.example.cocktails.presentation.cocktail.CocktailViewModel
import com.example.cocktails.presentation.main.MainViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component (
    modules = [RepositoryModule::class, DatabaseModule::class, ApiModule::class])
interface AppComponent {
    fun getMainViewModel() : MainViewModel

    fun getCocktailViewModel() : CocktailViewModel

    fun getMainActivityViewModel() : MainActivityViewModel

    @Component.Builder
    interface AppComponentBuilder {
        fun application(@BindsInstance application: Context) : AppComponentBuilder

        fun build() : AppComponent
    }
}