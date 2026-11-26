package com.example.devexplorer.ui.state

import com.example.devexplorer.data.remote.dto.GitHubProfileDto
import com.example.devexplorer.data.remote.dto.GitHubRepoDto

data class ProfileUiState(
    val isLoading: Boolean = false,
    val profile: GitHubProfileDto? = null,
    val repos: List<GitHubRepoDto> = emptyList(),
    val error: String? = null
)
