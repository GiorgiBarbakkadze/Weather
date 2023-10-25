package com.gb.data.repository

import com.gb.data.dto.RealTimeWeather
import com.gb.data.network.WeatherApi
import com.gb.domain.entities.CurrentWeather
import com.gb.domain.repositories.CurrentWeatherRepo

class RealTimeWeatherRepository(private val weatherApi: WeatherApi): BaseRepository<CurrentWeather, RealTimeWeather>(), CurrentWeatherRepo {
    override suspend fun getCurrentWeather(): CurrentWeather {
        TODO("Not yet implemented")
    }
}