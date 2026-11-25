package com.example.devexplorer.ui

import com.example.devexplorer.data.remote.dto.GitHubUserDto

data class UserUiState(
    val isLoading: Boolean = false,
    val users: GitHubUserDto = emptyList(),
    val error: String? = null
)
