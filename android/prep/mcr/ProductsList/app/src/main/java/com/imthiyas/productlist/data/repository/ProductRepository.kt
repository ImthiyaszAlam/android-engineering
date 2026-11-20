package com.imthiyas.productlist.data.repository

import com.imthiyas.productlist.data.api.ApiService
import com.imthiyas.productlist.data.model.ProductResponse

class ProductRepository(private val apiService: ApiService) {

    suspend fun getProducts(limit: Int, skip: Int): ProductResponse {
        return apiService.getProducts(limit, skip)
    }
}