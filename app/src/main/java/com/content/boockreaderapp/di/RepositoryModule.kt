package com.content.boockreaderapp.di

import android.content.Context
import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.repository.BookRepository
import com.content.boockreaderapp.util.SharedPreferenceManager
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
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

    @Provides
    @Singleton
    fun provideSharedPreferenceManger(
        @ApplicationContext context: Context
    ) : SharedPreferenceManager {
        return SharedPreferenceManager(context)
    }
}