package com.example.weather.data.di

import android.content.Context
import android.content.SharedPreferences
import com.example.weather.data.di.modules.DataModule
import com.example.weather.data.di.modules.NetworkModule
import com.example.weather.viewmodel.DaysWeatherFragmentViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DataModule::class])

interface AppComponent {
    fun inject(daysWeatherFragmentViewModel: DaysWeatherFragmentViewModel)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}