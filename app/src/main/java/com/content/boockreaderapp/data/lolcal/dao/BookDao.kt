package com.content.boockreaderapp.data.lolcal.dao

import androidx.room.*
import com.content.boockreaderapp.data.lolcal.entity.BookEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface BookDao {


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAllBooks(books: List<BookEntity>)

    @Query("SELECT * FROM books_table")
    fun getAllBooks(): Flow<List<BookEntity>>


    @Query("SELECT * FROM books_table WHERE book_title LIKE '%' || :query || '%' OR author_name LIKE '%' || :query || '%'")
    fun searchBooks(query: String): Flow<List<BookEntity>>

    @Query("SELECT * FROM books_table WHERE bookId = :bookId LIMIT 1")
    fun getBookById(bookId : Int) : BookEntity?

    @Query("SELECT * FROM books_table WHERE is_bookmarked = 1")
    fun getAllBookmarkedBooks() : Flow<List<BookEntity>>

    @Query("UPDATE books_table SET is_bookmarked = :isBookmarked WHERE bookId = :bookId")
    fun updateBookmarkState(bookId : Int, isBookmarked : Boolean) : Int

}