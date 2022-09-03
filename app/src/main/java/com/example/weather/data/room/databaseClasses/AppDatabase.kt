package com.example.weather.data.room.databaseClasses

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.data.room.dataAccessObjects.CurrentWeatherDataAccessObject
import com.example.weather.data.room.dataEntites.CurrentWeather

@Database(
    entities = [CurrentWeather::class],
    version = 1,
    exportSchema = true
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun currentWeatherDataAccessObject(): CurrentWeatherDataAccessObject

}