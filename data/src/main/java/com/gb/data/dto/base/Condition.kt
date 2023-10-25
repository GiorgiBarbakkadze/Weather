package com.gb.data.dto.base

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.entities.base.ConditionEntity
import com.squareup.moshi.Json

data class Condition(
    @Json(name = "text") val weatherDescription: String,
    @Json(name = "icon") val imageUrl: String,
    @Json(name = "code") val weatherConditionCode: Int
): MapFromDataToDomain<ConditionEntity> {
    override fun map() = ConditionEntity(weatherDescription, imageUrl, weatherConditionCode)
}