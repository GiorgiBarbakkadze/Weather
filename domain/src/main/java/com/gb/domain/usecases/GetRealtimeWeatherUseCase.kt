package com.gb.domain.usecases

import com.gb.domain.entities.CurrentWeather
import com.gb.domain.repositories.CurrentWeatherRepo
import kotlinx.coroutines.flow.Flow
import com.gb.domain.common.Result

class GetRealtimeWeatherUseCase(private val currentWeatherRepo: CurrentWeatherRepo) :
    BaseUseCase<Result<CurrentWeather>>() {

        fun executeUseCase(): Flow<Result<CurrentWeather>> {
            return invoke {
                currentWeatherRepo.getCurrentWeather()
            }
        }
}