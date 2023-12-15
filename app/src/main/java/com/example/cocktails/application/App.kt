package com.example.cocktails.application

import android.app.Application
import com.example.cocktails.di.AppComponent
import com.example.cocktails.di.DaggerAppComponent

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        appComponent = DaggerAppComponent.builder().application(this).build()
    }

    fun getAppComponent(): AppComponent = appComponent

    companion object {
        lateinit var appComponent : AppComponent
        private set
    }
}