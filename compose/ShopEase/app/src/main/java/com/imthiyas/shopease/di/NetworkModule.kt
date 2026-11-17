package com.imthiyas.shopease.di

import com.imthiyas.shopease.data.remote.api.ProductApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    val json=Json {
        ignoreUnknownKeys=true
    }

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {


        return Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(
                json.asConverterFactory("application/json".toMediaType())
            )
            .build()

    }


    @Provides
    @Singleton
    fun provideNetworkApi(retrofit: Retrofit): ProductApi {
        return retrofit.create<ProductApi>(ProductApi::class.java)
    }
}