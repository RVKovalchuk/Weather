package com.example.weather.data.di

import android.content.Context
import com.example.weather.data.di.modules.dataModule.DataModule
import com.example.weather.data.di.modules.NetworkModule
import com.example.weather.viewmodel.WeatherPerDaysFragmentViewModel
import com.example.weather.viewmodel.WeatherPerHoursFragmentViewModel
import dagger.BindsInstance
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class, DataModule::class])

interface AppComponent {
    fun inject(weatherPerDaysFragmentViewModel: WeatherPerDaysFragmentViewModel)
    fun inject(weatherPerHoursFragmentViewModel: WeatherPerHoursFragmentViewModel)

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }
}