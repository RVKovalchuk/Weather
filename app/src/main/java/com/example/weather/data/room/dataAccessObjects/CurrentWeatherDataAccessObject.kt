package com.example.weather.data.room.dataAccessObjects

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.weather.data.room.dataEntites.CurrentWeather

@Dao
interface CurrentWeatherDataAccessObject {
    @Query("SELECT * FROM current_weather_table")
    fun getCurrentWeather(): LiveData<CurrentWeather>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrentWeather(currentWeather: CurrentWeather)
}