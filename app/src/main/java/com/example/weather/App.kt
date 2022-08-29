package com.example.weather

import android.app.Application
import com.example.weather.data.di.AppComponent
import com.example.weather.data.di.DaggerAppComponent

class App : Application() {
    lateinit var dagger: AppComponent

    override fun onCreate() {
        super.onCreate()
        instance = this
        dagger = DaggerAppComponent.factory().create(this)
    }

    companion object {
        lateinit var instance: App
            private set
    }
}