package com.content.boockreaderapp.data.lolcal.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "books_table")
data class BookEntity(

    @PrimaryKey(autoGenerate = true)
    val bookId: Int = 0,

    @ColumnInfo(name = "book_title")
    val title: String,

    @ColumnInfo(name = "author_name")
    val author: String,

    // store as String (URL or asset path)
    //val cover: String? = null,

    @ColumnInfo(name = "is_started")
    val isStarted: Boolean = false,

    @ColumnInfo(name = "book_content")
    val content : String
)