package com.content.boockreaderapp.data.repository

import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import javax.inject.Inject


class BookRepositoryImpl @Inject constructor(
    private val bookDao: BookDao
) {
    suspend fun addAllBooks( books : List<BookEntity>) {
        bookDao.insertAllBooks(books)
    }

    fun getAllBooks() = bookDao.getAllBooks()
    fun searchBook(query : String ) = bookDao.searchBooks(query)
    fun getBookById(bookId : Int) = bookDao.getBookById(bookId)
    fun getAllBookmarkedBooks() = bookDao.getAllBookmarkedBooks()
    fun  updateBookmarkState(bookId : Int, isBookmarked : Boolean ) : Int {
       return bookDao.updateBookmarkState(bookId,isBookmarked)
    }
    fun  updateReadingState(bookId : Int, isStarted : Boolean ) : Int {
        return bookDao.updateReadingState(bookId,isStarted)
    }
}