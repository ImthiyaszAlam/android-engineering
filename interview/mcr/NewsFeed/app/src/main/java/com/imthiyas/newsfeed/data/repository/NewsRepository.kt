package com.imthiyas.newsfeed.data.repository

import com.imthiyas.newsfeed.data.model.NewsPost


interface NewsRepository {
    suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<NewsPost>
}


