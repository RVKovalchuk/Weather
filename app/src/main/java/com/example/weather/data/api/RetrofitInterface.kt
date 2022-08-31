package com.example.weather.data.api

import com.example.weather.data.api.classesDTO.WeatherDTO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitInterface {
    @GET(ConstantsApi.API_GET_ANNOTATION_URL)
    fun getWeatherFromApi(
        @Query(ConstantsApi.API_QUERY_KEY) key: String,
        @Query(ConstantsApi.API_QUERY_CITY) city: String
    ): Call<WeatherDTO>
}