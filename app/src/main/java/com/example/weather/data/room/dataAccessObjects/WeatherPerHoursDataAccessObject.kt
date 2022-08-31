package com.example.weather.data.room.dataAccessObjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weather.data.room.dataEntites.WeatherPerHours

@Dao
interface WeatherPerHoursDataAccessObject {

    @Query("SELECT * FROM weather_per_hours_table")
    fun getWeatherPerHoursFromDb(): LiveData<List<WeatherPerHours>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertWeatherPerHoursToDb(list: List<WeatherPerHours>)
}