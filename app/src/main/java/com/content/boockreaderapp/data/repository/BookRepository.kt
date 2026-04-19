package com.content.boockreaderapp.data.repository

import androidx.room.Insert
import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import javax.inject.Inject


class BookRepository @Inject constructor(
    private val bookDao: BookDao
) {
    suspend fun addAllBooks( books : List<BookEntity>) {
        bookDao.insertAllBooks(books)
    }

    fun getAllBooks() = bookDao.getAllBooks()
    fun searchBook(query : String ) = bookDao.searchBooks(query)
}