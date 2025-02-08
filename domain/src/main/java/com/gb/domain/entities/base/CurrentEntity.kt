package com.gb.domain.entities.base



data class CurrentEntity(
    val localTimeWhenRealTimeUpdatedUnix: Int,
    val localTimeWhenRealTimeUpdated: String,
    val temperatureInCelsius: Float,
    val temperatureInFahrenheit: Float,
    val isDayOrNight: Int,
    val condition: ConditionEntity,
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
