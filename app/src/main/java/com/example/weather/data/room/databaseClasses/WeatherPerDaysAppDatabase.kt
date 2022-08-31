package com.example.weather.data.room.databaseClasses

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.weather.data.room.dataAccessObjects.WeatherPerDaysDataAccessObject
import com.example.weather.data.room.dataEntites.WeatherPerDays

@Database(
    entities = [WeatherPerDays::class],
    version = 1,
    exportSchema = true
)
abstract class WeatherPerDaysAppDatabase : RoomDatabase() {
    abstract fun weatherPerDaysDataAccessObject(): WeatherPerDaysDataAccessObject

}