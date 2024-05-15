package com.example.qoutesapplication.di

import com.example.qoutesapplication.common.Common
import com.example.qoutesapplication.data.api.ApiService
import com.example.qoutesapplication.data.repository.DataRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Singleton
    @Provides
    fun provideApiService(): ApiService {
        return  Retrofit.Builder().baseUrl(Common.PATHS.pathUrl)
            .addConverterFactory(GsonConverterFactory.create()).build()
            .create(ApiService::class.java)
    }

    @Provides
    fun provideDataRepository(apiService: ApiService) : DataRepository {
        return DataRepository(apiService)
    }
}