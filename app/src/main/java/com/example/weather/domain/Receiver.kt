package com.example.weather.domain

import android.util.Log
import androidx.lifecycle.LiveData
import com.example.weather.data.api.ConstantsApi
import com.example.weather.data.api.RetrofitInterface
import com.example.weather.classesDTO.WeatherDTO
import com.example.weather.data.MainRepository
import com.example.weather.data.room.dataEntites.CurrentWeather
import com.example.weather.utils.ConverterCurrentFromApiToApp
import com.example.weather.utils.ConverterForecastFromApiToApp
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Receiver @Inject constructor(
    private val service: RetrofitInterface,
    private val repository: MainRepository
) {

    fun getWeatherInfoFromApi(city: String) {
        service.getWeatherFromApi(key = ConstantsApi.API_KEY, city = city)
            .enqueue(object : Callback<WeatherDTO> {

                override fun onResponse(call: Call<WeatherDTO>, response: Response<WeatherDTO>) {
                    val listForecastWeather =
                        ConverterForecastFromApiToApp.convert(response.body()!!.forecast.forecastday)

                    val currentWeather = ConverterCurrentFromApiToApp.convert(response.body()!!)
                    repository.insertToDbCurrentWeather(currentWeather = currentWeather)

                    Log.d("!!!", "$listForecastWeather")
                    Log.d("!!!", "$currentWeather")
                }

                override fun onFailure(call: Call<WeatherDTO>, t: Throwable) {
                    println(t.localizedMessage)
                    t.localizedMessage?.let { Log.d("!!!", it) }
                }
            })

    }

    fun getCurrentWeatherFromApi(): LiveData<CurrentWeather> = repository.getFromDbCurrentWeather()
}