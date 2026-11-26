package com.example.devexplorer.data.repository

import com.example.devexplorer.data.remote.GithubApiService
import com.example.devexplorer.data.remote.dto.GitHubProfileDto
import com.example.devexplorer.data.remote.dto.GitHubRepoDto
import com.example.devexplorer.data.remote.dto.GitHubUserDto
import com.example.devexplorer.data.remote.dto.SearchUserResponse
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: GithubApiService) {

    suspend fun searchUser(query: String): SearchUserResponse {
        return apiService.searchUser(query)
    }

    suspend fun getUserProfile(userName: String): GitHubProfileDto {
        return apiService.getUserProfile(userName)
    }

    suspend fun getUserRepo(userName: String): List<GitHubRepoDto> {
        return apiService.getUserRepo(userName)
    }


}