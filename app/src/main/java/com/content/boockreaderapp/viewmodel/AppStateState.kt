package com.content.boockreaderapp.viewmodel

sealed class AppStateState {
    object SplashScreenState : AppStateState()
    object Loading : AppStateState()
    object Idle : AppStateState()
}