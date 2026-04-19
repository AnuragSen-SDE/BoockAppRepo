package com.content.boockreaderapp.viewmodel

sealed class BookState <out T> {
    object Loading  : BookState<Nothing>()
    object Empty : BookState<Nothing>()
    class Success <out T>(val data : T)  : BookState<T>()
    data class Error ( val message : String) : BookState<Nothing>()
}