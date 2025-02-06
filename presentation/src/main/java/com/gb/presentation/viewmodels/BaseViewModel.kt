package com.gb.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gb.domain.common.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

open class BaseViewModel : ViewModel() {

    protected fun <T : Any> executeUseCase(
        flow: MutableSharedFlow<Result<T>>,
        action: () -> Flow<Result<T>>
    ) {
        action().onEach { result ->
            flow.emit(result)
        }.launchIn(viewModelScope)

    }
}