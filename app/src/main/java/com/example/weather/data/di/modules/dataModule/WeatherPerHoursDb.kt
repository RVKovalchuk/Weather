package com.example.weather.data.di.modules.dataModule

import android.content.Context
import androidx.room.Room
import com.example.weather.data.room.dataAccessObjects.WeatherPerHoursDataAccessObject
import com.example.weather.data.room.databaseClasses.WeatherPerHoursAppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class WeatherPerHoursDb {
    @Singleton
    @Provides
    fun provideWeatherPerHoursDatabase(context: Context): WeatherPerHoursAppDatabase =
        Room.databaseBuilder(
            context.applicationContext,
            WeatherPerHoursAppDatabase::class.java,
            "weather_per_hours_table"
        ).build()

    @Singleton
    @Provides
    fun providesWeatherPerHoursDataAccessObject(db: WeatherPerHoursAppDatabase): WeatherPerHoursDataAccessObject =
        db.getWeatherPerHoursDataAccessObject()
}