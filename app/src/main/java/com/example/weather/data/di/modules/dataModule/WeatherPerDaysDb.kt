package com.example.weather.data.di.modules.dataModule

import android.content.Context
import androidx.room.Room
import com.example.weather.data.room.dataAccessObjects.WeatherPerDaysDataAccessObject
import com.example.weather.data.room.databaseClasses.WeatherPerDaysAppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherPerDaysDb {
    @Singleton
    @Provides
    fun provideWeatherPerDaysDatabase(context: Context): WeatherPerDaysAppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            WeatherPerDaysAppDatabase::class.java,
            "weather_per_days_table"
        ).build()

    @Singleton
    @Provides
    fun providesWeatherPerDaysDataAccessObject(db: WeatherPerDaysAppDatabase): WeatherPerDaysDataAccessObject =
        db.weatherPerDaysDataAccessObject()
}