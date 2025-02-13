package com.gb.domain.usecases

import com.gb.domain.entities.WeatherEntity
import com.gb.domain.repositories.CurrentWeatherRepo
import kotlinx.coroutines.flow.Flow
import com.gb.domain.common.Result

class GetRealtimeWeatherUseCase(private val currentWeatherRepo: CurrentWeatherRepo) :
    BaseUseCase<Result<WeatherEntity>>() {

        fun executeUseCase(location: String): Flow<Result<WeatherEntity>> {
            return invoke {
                currentWeatherRepo.getCurrentWeather(location)
            }
        }
}