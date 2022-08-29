package com.example.weather.viewmodel

import android.content.SharedPreferences
import android.text.Editable
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weather.App
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.data.sharedPreferences.ConstantsSharedPreferences
import com.example.weather.domain.Receiver
import com.example.weather.utils.WeatherPerDays
import javax.inject.Inject

class DaysWeatherFragmentViewModel : ViewModel() {
    @Inject
    lateinit var receiver: Receiver

    @Inject
    lateinit var sharedPreferences: SharedPreferences

    val currentWeather : LiveData<CurrentWeather>

    init {
        App.instance.dagger.inject(this)
        currentWeather = receiver.getCurrentWeatherFromApi()
        receiver.getWeatherInfoFromApi()
    }

    fun refreshWeathersInfo(){
        receiver.getWeatherInfoFromApi()
    }

}