package com.content.boockreaderapp.data.repository

import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import kotlinx.coroutines.flow.Flow

interface BookRepository {

    suspend fun addAllBooks(books: List<BookEntity>)

    fun getAllBooks(): Flow<List<BookEntity>>

    fun searchBook(query: String): Flow<List<BookEntity>>

    fun getBookById(bookId: Int): Flow<BookEntity?>

    fun getAllBookmarkedBooks(): Flow<List<BookEntity>>

    suspend fun updateBookmarkState(bookId: Int, isBookmarked: Boolean): Int

    suspend fun updateReadingState(bookId: Int, isStarted: Boolean): Int
}