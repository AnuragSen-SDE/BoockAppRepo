package com.content.boockreaderapp.viewmodel

sealed class ReadingState {
    object Success : ReadingState()
    data class Error(val message : String) : ReadingState()
    object Idle : ReadingState()
    object Loading : ReadingState()
}