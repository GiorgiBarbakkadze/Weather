package com.gb.domain.common

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception?, val errorMessage: String) : Result<Nothing>()
}