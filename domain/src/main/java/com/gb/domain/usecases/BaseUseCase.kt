package com.gb.domain.usecases

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

open class BaseUseCase<T: Any> {
    protected fun invoke(action: suspend () -> T): Flow<T> = flow {
        emit(action())
    }
}