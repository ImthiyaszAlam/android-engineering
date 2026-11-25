package com.example.devexplorer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SearchUserResponse(
    @SerialName("total_count")
    val totalCount: Int,
    val items: List<GitHubUserDto>
)