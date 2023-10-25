package com.gb.data.dto.base

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.base.CurrentEntity
import com.squareup.moshi.Json

data class Current(
    @Json(name = "last_updated_epoch") val localTimeWhenRealTimeUpdatedUnix: Int,
    @Json(name = "last_updated") val localTimeWhenRealTimeUpdated: String,
    @Json(name = "temp_c") val temperatureInCelsius: Float,
    @Json(name = "temp_f") val temperatureInFahrenheit: Float,
    @Json(name = "is_day") val isDayOrNight: Int,
    val condition: Condition

): MapFromDataToDomain<CurrentEntity> {
    override fun map() = CurrentEntity(localTimeWhenRealTimeUpdatedUnix, localTimeWhenRealTimeUpdated, temperatureInCelsius, temperatureInFahrenheit, isDayOrNight, condition.map())
}

//"current": {
//    "last_updated_epoch": 1698049800,
//    "last_updated": "2023-10-23 09:30",
//    "temp_c": 10.0,
//    "temp_f": 50.0,
//    "is_day": 1,
//    "condition": {
//        "text": "Sunny",
//        "icon": "//cdn.weatherapi.com/weather/64x64/day/113.png",
//        "code": 1000
//    },