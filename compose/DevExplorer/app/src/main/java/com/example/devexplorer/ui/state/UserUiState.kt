package com.example.devexplorer.ui.state

import com.example.devexplorer.data.remote.dto.GitHubUserDto

data class UserUiState(
    val isLoading: Boolean = false,
    val query: String = "android",
    val users: List<GitHubUserDto> = emptyList(),
    val error: String? = null
)