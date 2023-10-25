package com.gb.domain.entities

import com.gb.domain.entities.base.CurrentEntity
import com.gb.domain.entities.base.LocationEntity

data class CurrentWeather(
    val location: LocationEntity,
    val current: CurrentEntity,
    val windInMph: Float,
    val windInKph: Float,
    val windDirectionInDegrees: Float,
    val windDirectionOnCompass: String,
    val humidity: Int,
    val cloud: Int,
    val feelsLikeInCelsius: Float,
    val feelsLikeInFahrenheit: Float,
    val ultravioletIndex: Float
)