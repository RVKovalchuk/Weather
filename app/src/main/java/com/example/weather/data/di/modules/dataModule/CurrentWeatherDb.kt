package com.example.weather.data.di.modules.dataModule

import android.content.Context
import androidx.room.Room
import com.example.weather.data.room.dataAccessObjects.CurrentWeatherDataAccessObject
import com.example.weather.data.room.databaseClasses.AppDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CurrentWeatherDb {
    @Singleton
    @Provides
    fun provideCurrentWeatherDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, "current_weather_table"
        ).build()

    @Singleton
    @Provides
    fun providesCurrentWeatherDataAccessObject(db: AppDatabase): CurrentWeatherDataAccessObject =
        db.currentWeatherDataAccessObject()
}