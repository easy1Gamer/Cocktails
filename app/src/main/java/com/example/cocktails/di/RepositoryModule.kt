package com.example.cocktails.di

import com.example.cocktails.data.Repository
import com.example.cocktails.data.RepositoryImpl
import dagger.Module
import dagger.Provides

@Module
object RepositoryModule {

    @Provides
    fun provideRepository(impl: RepositoryImpl): Repository {
        return impl
    }

}