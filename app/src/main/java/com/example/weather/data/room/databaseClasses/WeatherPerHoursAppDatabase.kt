package com.example.weather.data.room.databaseClasses

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.data.room.dataAccessObjects.WeatherPerHoursDataAccessObject
import com.example.weather.data.room.dataEntites.WeatherPerHours

@Database(
    entities = [WeatherPerHours::class],
    version = 1,
    exportSchema = true
)
abstract class WeatherPerHoursAppDatabase : RoomDatabase() {
    abstract fun getWeatherPerHoursDataAccessObject(): WeatherPerHoursDataAccessObject
}