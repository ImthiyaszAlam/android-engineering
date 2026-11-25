package com.example.devexplorer.ui

import com.example.devexplorer.data.remote.dto.GitHubUserDto

data class UserUiState(
    val Loading: Boolean = false,
    val users: List<GitHubUserDto> = emptyList(),
    val error: String? = null
)
