package com.example.weather.data

import androidx.lifecycle.LiveData
import com.example.weather.data.room.dataAccessObjects.CurrentWeatherDataAccessObject
import com.example.weather.data.room.dataEntites.CurrentWeather
import java.util.concurrent.Executors
import javax.inject.Inject


class MainRepository @Inject constructor(
    private val currentWeatherDataAccessObject: CurrentWeatherDataAccessObject
) {
    fun insertToDbCurrentWeather(currentWeather: CurrentWeather) {
        Executors.newSingleThreadExecutor().execute {
            currentWeatherDataAccessObject.insertCurrentWeather(currentWeather = currentWeather)
        }
    }



    fun getFromDbCurrentWeather(): LiveData<CurrentWeather> =
        currentWeatherDataAccessObject.getCurrentWeather()
}