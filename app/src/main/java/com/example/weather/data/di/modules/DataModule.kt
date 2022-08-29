package com.example.weather.data.di.modules

import android.content.Context
import android.content.SharedPreferences
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.weather.data.room.dataAccessObjects.CurrentWeatherDataAccessObject
import com.example.weather.data.room.databaseClasses.AppDatabase
import com.example.weather.data.sharedPreferences.ConstantsSharedPreferences
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataModule {

    @Singleton
    @Provides
    fun provideSharedPreferences(context: Context): SharedPreferences =
        context.applicationContext.getSharedPreferences(
            ConstantsSharedPreferences.NAME_OF_PREFERENCE_FOR_LOCATION,
            Context.MODE_PRIVATE
        )

    @Singleton
    @Provides
    fun provideCurrentWeatherDatabase(context: Context): AppDatabase =
        Room.databaseBuilder(
            context.applicationContext, AppDatabase::class.java, "current_weather_table"
        ).build()

    @Singleton
    @Provides
    fun providesCurrentWeatherDataAccessObject(db: AppDatabase) : CurrentWeatherDataAccessObject =
        db.currentWeatherDataAccessObject()
}
