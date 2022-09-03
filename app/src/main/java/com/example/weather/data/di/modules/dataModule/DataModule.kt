package com.example.weather.data.di.modules.dataModule

import android.content.Context
import android.content.SharedPreferences
import com.example.weather.data.sharedPreferences.ConstantsSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(includes = [CurrentWeatherDb::class, WeatherPerDaysDb::class, WeatherPerHoursDb::class])
class DataModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.applicationContext.getSharedPreferences(
            ConstantsSharedPreferences.NAME_OF_PREFERENCE_FOR_LOCATION,
            Context.MODE_PRIVATE
        )
}
