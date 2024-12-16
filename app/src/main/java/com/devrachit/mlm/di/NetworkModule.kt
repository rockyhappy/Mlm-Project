package com.devrachit.mlm.di

import android.content.Context
import com.devrachit.mlm.data.local.DataStoreRepository
import com.devrachit.mlm.data.remote.ApiServices
import com.devrachit.mlm.data.repository.ApiServicesRepositoryImpl
import com.devrachit.mlm.domain.repository.ApiServicesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule
{

    @Provides
    @Singleton
    fun provideDataStoreRepository(@ApplicationContext context: Context): DataStoreRepository {
        return DataStoreRepository(context)
    }

    @Provides
    @Singleton
    fun provideContext(@ApplicationContext context: Context): Context {
        return context
    }
    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://adsmaker.edumakers.online/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideApiService(retrofit: Retrofit): ApiServices {
        return retrofit.create(ApiServices::class.java)
    }

    @Provides
    @Singleton
    fun provideApiServicesRepository(apiService: ApiServices): ApiServicesRepository {
        return ApiServicesRepositoryImpl(apiService)
    }

    @Provides
    @Singleton
    fun provideApiKeys(): String{
        return "Bearer adss548557"
    }
}