package com.example.devexplorer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubProfileDto(
    val id: Int,
    val login: String,
    val name: String? = null,

    @SerialName("avatar_url")
    val avatarUrl: String,

    val bio: String? = null,
    val followers: Int,
    val following: Int,

    @SerialName("public_repos")
    val publicRepos: Int,

    @SerialName("html_url")
    val htmlUrl: String

)
