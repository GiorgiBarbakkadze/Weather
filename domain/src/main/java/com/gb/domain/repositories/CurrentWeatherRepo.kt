package com.gb.domain.repositories

import com.gb.domain.common.Result
import com.gb.domain.entities.WeatherEntity

interface CurrentWeatherRepo {
    suspend fun getCurrentWeather(location: String): Result<WeatherEntity>
}