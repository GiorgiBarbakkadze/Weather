package com.gb.domain.entities.base

data class LocationEntity(
    val name: String,
    val region: String,
    val country: String,
    val latitude: Float,
    val longitude: Float,
    val timeZoneName: String,
    val dateAndTimeUnix: Int,
    val localTime : String

)
