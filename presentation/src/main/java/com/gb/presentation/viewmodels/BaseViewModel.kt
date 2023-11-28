package com.gb.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

open class BaseViewModel : ViewModel() {

    protected fun executeUseCase (action : suspend () -> Unit) {
        viewModelScope.launch {
            action()
        }

    }
}