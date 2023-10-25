package com.gb.data.network

import com.gb.data.Constants
import com.gb.data.dto.RealTimeWeather
import retrofit2.Response
import retrofit2.http.GET

interface WeatherApi {
    @GET("current.json?key=${Constants.API_KEY}&q=London&aqi=no")
    suspend fun getCurrentWeatherFromApi(): Response<RealTimeWeather>
}