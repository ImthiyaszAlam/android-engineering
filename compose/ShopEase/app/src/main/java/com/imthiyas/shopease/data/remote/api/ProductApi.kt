package com.imthiyas.shopease.data.remote.api

import com.imthiyas.shopease.data.remote.models.Category
import com.imthiyas.shopease.data.remote.models.Product
import com.imthiyas.shopease.data.remote.models.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(
        @Query("total") total: Int,
        @Query("limit") limit: Int = 20,
        @Query("skip") skip: Int = 0
    ): ProductResponse


    @GET("/products/categories")
    suspend fun getCategories(): List<Category>

    @GET("/products/search")
    suspend fun search(
        @Query("q") query: String
    ): ProductResponse


}