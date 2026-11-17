package com.imthiyas.shopease.data.repository

import com.imthiyas.shopease.data.remote.api.ProductApi
import com.imthiyas.shopease.data.remote.models.Category
import com.imthiyas.shopease.data.remote.models.Product
import com.imthiyas.shopease.data.remote.models.ProductResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val productApi: ProductApi
) {

    suspend fun getProducts(total: Int, limit: Int, skip: Int): List<Product> {
        return productApi.getProducts(total, limit, skip).products
    }

    suspend fun getCategories(): List<Category> {
        return productApi.getCategories()
    }

    suspend fun searchProducts(query: String): List<Product> {
        return productApi.search(query).products
    }
}