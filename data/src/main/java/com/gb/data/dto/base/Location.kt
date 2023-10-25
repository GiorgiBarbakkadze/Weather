package com.gb.data.dto.base

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.base.LocationEntity
import com.squareup.moshi.Json

data class Location(
    val name: String,
    val region: String,
    val country: String,
    @Json(name = "lat") val latitude: Float,
    @Json(name = "lon") val longitude: Float,
    @Json(name = "tz_id") val timeZoneName: String,
    @Json(name = "localtime_epoch") val dateAndTimeUnix: Int,
    val localTime : String

): MapFromDataToDomain<LocationEntity> {
    override fun map() = LocationEntity(name, region, country, latitude, longitude, timeZoneName, dateAndTimeUnix, localTime)
}



//"location": {
//    "name": "London",
//    "region": "City of London, Greater London",
//    "country": "United Kingdom",
//    "lat": 51.52,
//    "lon": -0.11,
//    "tz_id": "Europe/London",
//    "localtime_epoch": 1698050517,
//    "localtime": "2023-10-23 9:41"
//},
