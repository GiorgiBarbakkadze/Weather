package com.gb.domain.entities.base



data class CurrentEntity(
    val localTimeWhenRealTimeUpdatedUnix: Int,
    val localTimeWhenRealTimeUpdated: String,
    val temperatureInCelsius: Float,
    val temperatureInFahrenheit: Float,
    val isDayOrNight: Int,
    val condition: ConditionEntity

)
