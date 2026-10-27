package com.imthiyas.newsfeed.ui

import com.imthiyas.newsfeed.data.model.NewsPost

data class NewsUiState(

    val posts: List<NewsPost> = emptyList(),
    val page: Int = 0,
    val hasMore: Boolean = true,
    val isRefreshing: Boolean = false,
    val isLoadingMore: Boolean = false,
    val error: String? = null,
    val refreshError: String? = null,
    val loadMoreError: String? = null
)