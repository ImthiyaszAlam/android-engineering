package com.imthiyas.productlist.data.api

import com.imthiyas.productlist.data.model.ProductResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {


    @GET(ApiEndPoints.PRODUCTS)
    suspend fun getProducts(
        @Query("limit") limit: Int,
        @Query("skip") skip: Int
    ): ProductResponse
}