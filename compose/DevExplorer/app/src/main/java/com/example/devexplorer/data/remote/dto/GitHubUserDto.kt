package com.example.devexplorer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubUserDto(
    val id: Int,
    val login: String,
    @SerialName("avatar_url")
    val avatarUrl: String,
    @SerialName("html_url")
    val profileUrl: String
)
