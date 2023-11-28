package com.gb.presentation

import com.gb.domain.usecases.GetRealtimeWeatherUseCase

class ForTestingPurpose(private val getRealtimeWeatherUseCase: GetRealtimeWeatherUseCase) {
    suspend fun getDataBroo() = getRealtimeWeatherUseCase.getRealtimeWeather()
}