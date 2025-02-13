package com.gb.data.network

import com.gb.data.dto.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {
    @GET("forecast.json?days=10&aqi=yes&alerts=no")
    suspend fun getWeatherFromApi(@Query("q") location: String): Response<WeatherResponse>
}