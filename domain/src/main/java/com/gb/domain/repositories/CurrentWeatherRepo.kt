package com.gb.domain.repositories

import com.gb.domain.common.Result
import com.gb.domain.entities.CurrentWeather

interface CurrentWeatherRepo {
    suspend fun getCurrentWeather(): Result<CurrentWeather>
}