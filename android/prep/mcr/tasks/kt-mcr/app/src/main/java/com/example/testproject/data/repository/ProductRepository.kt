package com.example.testproject.data.repository

import com.example.testproject.data.api.ApiService
import com.example.testproject.data.model.ProductResponse

class ProductRepository(private val apiService: ApiService) {



    suspend fun getProducts(limit: Int, skip: Int): ProductResponse {
        return apiService.getProducts(limit, skip)
    }
}