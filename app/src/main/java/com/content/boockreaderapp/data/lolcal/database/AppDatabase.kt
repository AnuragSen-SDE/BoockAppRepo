package com.content.boockreaderapp.data.lolcal.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.lolcal.entity.BookEntity

@Database(
    entities = [BookEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun bookDao(): BookDao
}