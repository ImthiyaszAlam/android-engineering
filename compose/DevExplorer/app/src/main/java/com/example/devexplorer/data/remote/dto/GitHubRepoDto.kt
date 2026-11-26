package com.example.devexplorer.data.remote.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class GitHubRepoDto(
    val id: Int,
    val name: String,
    val description: String? = null,

    @SerialName("stargazers_count")
    val stars: Int,

    val language: String? = null,

    @SerialName("html_url")
    val htmlUrl: String
)