package com.gb.domain.repositories

import com.gb.domain.entities.CurrentWeather

interface CurrentWeatherRepo {
    suspend fun getCurrentWeather(): CurrentWeather
}