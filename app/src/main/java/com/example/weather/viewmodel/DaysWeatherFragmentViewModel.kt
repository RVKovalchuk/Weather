package com.example.weather.viewmodel

import android.content.SharedPreferences
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.weather.App
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.domain.Receiver
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
        receiver.getWeatherInfoFromApi("Baranovichi")
    }

    fun refreshWeathersInfo(){
        receiver.getWeatherInfoFromApi("Baranovichi")
    }

}