package com.gb.data.dto

import com.gb.data.dto.base.Current
import com.gb.data.dto.base.Location
import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.WeatherEntity
import com.squareup.moshi.Json

data class WeatherResponse(
    val location: Location,
    val current: Current,
    val forecast: Forecast


): MapFromDataToDomain<WeatherEntity> {
    override fun map(): WeatherEntity {
        return WeatherEntity(location = location.map(), current = current.map(), forecast.map())
    }
}
