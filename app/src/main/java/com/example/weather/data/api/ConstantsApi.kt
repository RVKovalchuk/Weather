package com.example.weather.data.api

object ConstantsApi {
    const val API_BASE_URL = "https://api.weatherapi.com/v1/"
    const val API_KEY = "d16a0276d9604fa2ae7111416220107"
    const val API_GET_ANNOTATION_URL = "forecast.json?days=3&aqi=no&alerts=no"
    const val API_QUERY_KEY = "key"
    const val API_QUERY_CITY = "q"
    const val CLIENT_CALL_TIMEOUT = 30L
    const val CLIENT_READ_TIMEOUT = 30L
}