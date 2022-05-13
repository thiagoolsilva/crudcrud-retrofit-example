package com.lopes.crudcrudretrofit.di

import com.lopes.crudcrudretrofit.BuildConfig
import com.lopes.crudcrudretrofit.data.api.ComicAPIContract
import com.lopes.crudcrudretrofit.data.api.adapters.ComicsArrayListAdapter
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

private const val BASE_URL = "https://crudcrud.com/api/${BuildConfig.API_KEY}/"

@Module
@InstallIn(SingletonComponent::class)
object ComicsNetworkModule {
    @Provides
    @Singleton
    fun providesSearchAPI(): ComicAPIContract {
        val logger = HttpLoggingInterceptor()
        logger.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logger)
            .build()

        val moshi = Moshi.Builder()
            .add(ComicsArrayListAdapter())
            .build()

        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .build()
            .create(ComicAPIContract::class.java)
    }
}