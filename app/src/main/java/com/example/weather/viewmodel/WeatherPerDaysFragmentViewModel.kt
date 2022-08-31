package com.example.weather.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weather.App
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.room.dataEntites.WeatherPerDays
import com.example.weather.model.domain.Receiver
import javax.inject.Inject

class WeatherPerDaysFragmentViewModel : ViewModel() {
    @Inject
    lateinit var receiver: Receiver

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    val currentWeather: LiveData<CurrentWeather>
    val weatherPerDays: LiveData<List<WeatherPerDays>>

    init {
        App.instance.dagger.inject(this)
        receiver.getWeatherInfoFromApi("Brest")
        currentWeather = receiver.getCurrentWeatherFromDb()
        weatherPerDays = receiver.getWeatherPerDaysFromDb()
    }

    fun refreshWeathersInfo() {
        receiver.getWeatherInfoFromApi("Brest")
    }

}