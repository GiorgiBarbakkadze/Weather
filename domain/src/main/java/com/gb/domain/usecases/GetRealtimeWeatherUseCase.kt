package com.gb.domain.usecases

import com.gb.domain.repositories.CurrentWeatherRepo

class GetRealtimeWeatherUseCase(private val currentWeatherRepo: CurrentWeatherRepo) {
    suspend fun getRealtimeWeather() = currentWeatherRepo.getCurrentWeather()
}