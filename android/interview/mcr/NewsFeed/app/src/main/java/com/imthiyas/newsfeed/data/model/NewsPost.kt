package com.imthiyas.newsfeed.data.model

data class NewsPost(
    val userId: Int,
    val id: Int,
    val title: String,
    val body: String
)