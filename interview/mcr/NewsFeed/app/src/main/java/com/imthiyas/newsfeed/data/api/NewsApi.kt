package com.imthiyas.newsfeed.data.api

import com.imthiyas.newsfeed.data.model.NewsPost
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("posts")
    suspend fun getPosts(
        @Query("_page") page: Int,
        @Query("_limit") limit: Int,
    ): List<NewsPost>
}