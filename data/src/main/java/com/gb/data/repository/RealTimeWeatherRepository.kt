package com.gb.data.repository

import com.gb.data.dto.RealTimeWeather
import com.gb.data.network.WeatherApi
import com.gb.data.network.provideData
import com.gb.domain.common.Result
import com.gb.domain.entities.CurrentWeather
import com.gb.domain.repositories.CurrentWeatherRepo
import retrofit2.Response

class RealTimeWeatherRepository(private val weatherApi: WeatherApi): BaseRepository<CurrentWeather, RealTimeWeather>(), CurrentWeatherRepo {
    override suspend fun getCurrentWeather(): Result<CurrentWeather> {
        return fetchData { weatherApi.getCurrentWeatherFromApi().provideData() }
    }
}