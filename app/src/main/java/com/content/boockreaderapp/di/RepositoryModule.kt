package com.content.boockreaderapp.di

import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.repository.BookRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideBookRepository(
        bookDao: BookDao
    ): BookRepository {
        return BookRepository(bookDao)
    }
}