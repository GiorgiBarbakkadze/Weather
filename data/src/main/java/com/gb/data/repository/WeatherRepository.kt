package com.gb.data.repository

import com.gb.data.dto.WeatherResponse
import com.gb.data.network.WeatherApi
import com.gb.data.network.provideData
import com.gb.domain.common.Result
import com.gb.domain.entities.WeatherEntity
import com.gb.domain.repositories.CurrentWeatherRepo

class WeatherRepository(private val weatherApi: WeatherApi): BaseRepository<WeatherEntity, WeatherResponse>(), CurrentWeatherRepo {
    override suspend fun getCurrentWeather(location: String): Result<WeatherEntity> {
        return fetchData { weatherApi.getWeatherFromApi(location).provideData() }
    }
}