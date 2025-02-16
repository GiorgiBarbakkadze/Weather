package com.gb.domain.entities

import java.io.Serializable

data class AstroEntity(
    val sunrise: String,
    val sunset: String,
    val moonrise: String,
    val moonset: String,
    val moonPhase: String,
    val moonIllumination: Int,
    val isMoonUp: Int,
    val isSunUp: Int
): Serializable