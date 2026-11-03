package com.imthiyas.shopease.data.remote.api

import com.imthiyas.shopease.data.remote.models.Product
import com.imthiyas.shopease.data.remote.models.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ProductApi {

    @GET("/products")
    suspend fun getProducts(
        @Query("limit") limit: Int = 20,
        @Query("skip") skip: Int = 0
    ): ProductResponse
}