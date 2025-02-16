package com.gb.data.network

import com.gb.domain.entities.ErrorResponse
import com.gb.domain.common.Result
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response

interface MapFromDataToDomain<T : Any> {
    fun map(): T
}

inline fun <T : Any> Response<T>.onSuccess(startAction: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(startAction)
    return this
}

inline fun <T : Any> Response<T>.onError(networkError: (ErrorResponse) -> Unit?): Response<T> {
    if (!isSuccessful) {
        val errorBody = errorBody()?.string()
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter: JsonAdapter<ErrorResponse> = moshi.adapter(ErrorResponse::class.java)
        val errorResponse = jsonAdapter.fromJson(errorBody ?: "")
        if (errorResponse != null) {
            networkError(errorResponse)
        }
    }
    return this
}

fun <T : MapFromDataToDomain<R>, R : Any> Response<T>.provideData(): Result<R> {
    try {
        onSuccess { return Result.Success(it.map()) }
//        onError { return Result.Error(errorCode = it.error.code, errorMessage = it.error.message) }
        onError { return Result.Error(errorCode = it.error.code, errorMessage = it.error.message) }
        return Result.Error()
    } catch (e: Exception) {
        return Result.Error(e, -1, e.message!!)
    }
}