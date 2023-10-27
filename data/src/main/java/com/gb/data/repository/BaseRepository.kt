package com.gb.data.repository

import com.gb.data.network.MapFromDataToDomain
import com.gb.domain.common.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseRepository<T: Any, R: MapFromDataToDomain<T>> {

    protected suspend fun fetchData(dataProvider: suspend () -> Result<T>): Result<T> {
        return withContext(Dispatchers.IO) {
            dataProvider()
        }
    }
}