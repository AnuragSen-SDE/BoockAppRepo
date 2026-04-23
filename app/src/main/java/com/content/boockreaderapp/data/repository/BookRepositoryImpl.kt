package com.content.boockreaderapp.data.repository

import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import javax.inject.Inject


class BookRepositoryImpl @Inject constructor(
    private val bookDao: BookDao
) : BookRepository {

    override suspend fun addAllBooks(books: List<BookEntity>) {
        bookDao.insertAllBooks(books)
    }

    override fun getAllBooks() = bookDao.getAllBooks()

    override fun searchBook(query: String) = bookDao.searchBooks(query)

    override fun getBookById(bookId: Int) = bookDao.getBookById(bookId)

    override fun getAllBookmarkedBooks() = bookDao.getAllBookmarkedBooks()

    override suspend fun updateBookmarkState(bookId: Int, isBookmarked: Boolean): Int {
        return bookDao.updateBookmarkState(bookId, isBookmarked)
    }

    override suspend fun updateReadingState(bookId: Int, isStarted: Boolean): Int {
        return bookDao.updateReadingState(bookId, isStarted)
    }
}