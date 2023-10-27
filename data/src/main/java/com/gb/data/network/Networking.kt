package com.gb.data.network

import com.gb.domain.common.Result
import retrofit2.Response

interface MapFromDataToDomain <T: Any>{
    fun map(): T
}

inline fun <T: Any> Response<T>.onSuccess(startAction: (T) -> Unit): Response<T> {
    if (isSuccessful) body()?.run(startAction)
    return this
}

inline fun <T: Any> Response<T>.onError(error: (Exception) -> Unit): Response<T> {
    if(!isSuccessful) errorBody().run { message() }
    return this
}

fun <T: MapFromDataToDomain<R>, R: Any> Response<T>.provideData(): Result<R> {
    try {
        onSuccess { return Result.Success(it.map()) }
        onError { return Result.Error(it, it.message!!) }
        return Result.Error(null, "Some shit just happened")
    } catch (e: Exception) {
        return Result.Error(e, e.message!!)
    }
}