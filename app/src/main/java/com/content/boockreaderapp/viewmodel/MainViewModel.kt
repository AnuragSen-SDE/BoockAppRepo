package com.content.boockreaderapp.viewmodel

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import com.content.boockreaderapp.data.repository.BookRepository
import com.content.boockreaderapp.util.DummyData
import com.content.boockreaderapp.util.SharedPreferenceManager
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import java.io.IOException

@HiltViewModel
class MainViewModel @Inject constructor(
    val repository: BookRepository,
    val preferenceManager: SharedPreferenceManager
) : ViewModel() {



    private val _splashScreenState : MutableStateFlow<AppStateState> = MutableStateFlow(AppStateState.SplashScreenState)
    val splashScreenState : StateFlow<AppStateState> get() = _splashScreenState

    fun updateSplashState(){
        viewModelScope.launch {
            //delay(1000)
            if (!preferenceManager.getIsDataAdded()) repository.addAllBooks(DummyData.getDummyData())
            _splashScreenState.value = AppStateState.Idle
        }
    }

    private val _getAllBookState : MutableStateFlow<BookState<List<BookEntity>>> = MutableStateFlow(
        BookState.Loading)
    val getAllBookState : StateFlow<BookState<List<BookEntity>>> = _getAllBookState.asStateFlow()

    fun getAllBooks() {
        viewModelScope.launch (Dispatchers.IO) {
            repository.getAllBooks()
                .onStart {
                    _getAllBookState.value = BookState.Loading
                }
                .catch{ e ->
                    _getAllBookState.value = BookState.Error(e.message ?: "Something Went Wrong")
                }
                .collect {list ->
                    _getAllBookState.value =
                        if (list.isEmpty()) BookState.Empty
                    else BookState.Success(list)
                }
        }
    }

    fun searchBook(query : String ){
        viewModelScope.launch(Dispatchers.IO) {
            repository.searchBook(query)
                .onStart {
                    _getAllBookState.value = BookState.Loading
                }
                .catch{ e ->
                    _getAllBookState.value = BookState.Error(e.message ?: "Something Went Wrong")
                }
                .collect {list ->
                    _getAllBookState.value =
                        if (list.isEmpty()) BookState.Empty
                        else BookState.Success(list)
                }
        }
    }

    private val _getBookByIdState : MutableStateFlow<BookState<BookEntity>> = MutableStateFlow(
        BookState.Loading)
    val getBookByIdState : StateFlow<BookState<BookEntity>> = _getBookByIdState.asStateFlow()

    fun getBookById(bookId : Int){
        viewModelScope.launch (Dispatchers.IO) {
            _getBookByIdState.value = BookState.Loading
            val response = repository.getBookById(bookId)
            if (response == null ){
                _getBookByIdState.value = BookState.Error("Book Not found!!")
                return@launch
            }
            _getBookByIdState.value = BookState.Success(response)
        }
    }

}