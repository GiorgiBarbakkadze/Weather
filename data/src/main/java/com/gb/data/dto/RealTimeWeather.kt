package com.gb.data.dto

import com.gb.data.dto.base.Current
import com.gb.data.dto.base.Location
import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.CurrentWeather
import com.squareup.moshi.Json

data class RealTimeWeather(
    val location: Location,
    val current: Current,


): MapFromDataToDomain<CurrentWeather> {
    override fun map(): CurrentWeather {
        return CurrentWeather(location.map(), current.map())
    }
}
