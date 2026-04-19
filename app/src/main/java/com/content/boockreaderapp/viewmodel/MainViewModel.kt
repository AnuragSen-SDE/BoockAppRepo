package com.content.boockreaderapp.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.data.repository.BookRepository
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import java.io.IOException

class MainViewModel @Inject constructor(
    val repository: BookRepository
) : ViewModel() {
    private val _splashScreenState : MutableStateFlow<AppStateState> = MutableStateFlow(AppStateState.SplashScreenState)
    val splashScreenState : StateFlow<AppStateState> get() = _splashScreenState

    fun updateSplashState(){
        viewModelScope.launch {
            delay(1000)
            _splashScreenState.value = AppStateState.Idle
        }
    }

    private val _getAllBookState : MutableStateFlow<BookState<List<BookEntity>>> = MutableStateFlow(
        BookState.Loading)
    val getAllBookState = _getAllBookState.asStateFlow()

    fun getAllData() {
        viewModelScope.launch (Dispatchers.IO) {
            _getAllBookState.value = BookState.Loading
            try {
                val response = repository.getAllBooks()
                _getAllBookState.value = BookState.Success(response)
            }catch (e : IOException){

            }
        }
    }
}