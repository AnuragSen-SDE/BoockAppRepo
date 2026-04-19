package com.content.boockreaderapp.di

import com.content.boockreaderapp.data.lolcal.dao.BookDao
import com.content.boockreaderapp.data.repository.BookRepository
import com.content.boockreaderapp.viewmodel.MainViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ViewmodelModule {
    @Provides
    @Singleton
    fun provideMainViewModel(
        repository: BookRepository
    ): MainViewModel {
        return MainViewModel(repository)
    }
}