package com.imthiyas.newsfeed.data.repository

import com.imthiyas.newsfeed.data.api.NewsApi
import com.imthiyas.newsfeed.data.model.NewsPost

class NewsRepositoryImpl(
    private val api: NewsApi
) : NewsRepository {


    override suspend fun getPosts(
        page: Int,
        pageSize: Int
    ): List<NewsPost> {
        require(page>=1)
        require(pageSize>0)

        return api.getPosts(page,pageSize)
    }


}