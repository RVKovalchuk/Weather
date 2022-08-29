package com.example.weather.data.di.modules

import com.example.weather.data.api.ConstantsApi
import com.example.weather.data.api.RetrofitInterface
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
class NetworkModule  {
    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient = OkHttpClient.Builder()
        .callTimeout(ConstantsApi.CLIENT_CALL_TIMEOUT, TimeUnit.SECONDS)
        .readTimeout(ConstantsApi.CLIENT_READ_TIMEOUT, TimeUnit.SECONDS)
        .addInterceptor(HttpLoggingInterceptor().apply {
            if (com.example.weather.BuildConfig.DEBUG) {
                level = HttpLoggingInterceptor.Level.BASIC
            }
        })
        .build()

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder()
        .baseUrl(ConstantsApi.API_BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideRetrofitInterface(retrofit: Retrofit): RetrofitInterface =
        retrofit.create(RetrofitInterface::class.java)
}