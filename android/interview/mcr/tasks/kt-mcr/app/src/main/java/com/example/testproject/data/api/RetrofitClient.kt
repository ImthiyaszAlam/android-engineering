package com.example.testproject.data.api

import retrofit2.Retrofit

class RetrofitClient {

    private val BASE_URL = " https://dummyjson.com/"

    val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .build()
    }

    val apiService:
            ApiService = retrofit.create<ApiService>(ApiService::class.java)
}