package com.example.weather.data.room.dataAccessObjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weather.data.room.dataEntites.WeatherPerDays

@Dao
interface WeatherPerDaysDataAccessObject {
    @Query("SELECT * FROM weather_per_days_table")
    fun getWeatherPerDaysFromDb(): LiveData<List<WeatherPerDays>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherPerDaysToDb(list: List<WeatherPerDays>)
}