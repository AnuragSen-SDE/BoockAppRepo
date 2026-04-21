package com.content.boockreaderapp.viewmodel

sealed class BookmarkState {
    data class BookmarkUpdate(val isBookMarked : Boolean ) : BookmarkState()
    data class Error ( val message : String) : BookmarkState()
    object  Loading : BookmarkState()
    object Idal : BookmarkState()
}