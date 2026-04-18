package com.content.boockreaderapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {
    private val _splashScreenState : MutableStateFlow<AppStateState> = MutableStateFlow(AppStateState.SplashScreenState)
    val splashScreenState : StateFlow<AppStateState> get() = _splashScreenState

    fun updateSplashState(){
        viewModelScope.launch {
            delay(1000)
            _splashScreenState.value = AppStateState.Idle
        }
    }
}