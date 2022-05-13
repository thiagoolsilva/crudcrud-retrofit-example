package com.lopes.crudcrudretrofit.di

import com.lopes.crudcrudretrofit.data.repository.ComicRepositoryImpl
import com.lopes.crudcrudretrofit.data.source.ComicsNetworkSourceImpl
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryContract
import com.lopes.crudcrudretrofit.domain.repository.ComicsRepositoryNetworkContract
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class ComicsRepositoryModule {
    @Binds
    @Singleton
    abstract fun providesComicsRepository(impl: ComicRepositoryImpl): ComicsRepositoryContract

    @Binds
    @Singleton
    abstract fun providesComicsNetworkRepository(impl: ComicsNetworkSourceImpl): ComicsRepositoryNetworkContract
}