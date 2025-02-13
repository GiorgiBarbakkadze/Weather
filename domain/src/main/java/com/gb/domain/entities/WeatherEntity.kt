package com.gb.domain.entities

import com.gb.domain.entities.base.CurrentEntity
import com.gb.domain.entities.base.LocationEntity

data class WeatherEntity(
    val location: LocationEntity,
    val current: CurrentEntity,
    val forecastEntity: ForecastEntity
)