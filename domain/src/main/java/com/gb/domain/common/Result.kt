package com.gb.domain.common

import com.gb.domain.entities.ErrorResponse

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(
        val exception: Exception? = null,
        val errorCode: Int? = null,
        val errorMessage: String? = null
    ) : Result<Nothing>()

    object Loading : Result<Nothing>()
}