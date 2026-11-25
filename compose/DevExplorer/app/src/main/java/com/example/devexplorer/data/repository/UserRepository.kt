package com.example.devexplorer.data.repository

import com.example.devexplorer.data.remote.GithubApiService
import com.example.devexplorer.data.remote.dto.GitHubUserDto
import com.example.devexplorer.data.remote.dto.SearchUserResponse
import javax.inject.Inject

class UserRepository @Inject constructor(private val apiService: GithubApiService) {

    suspend fun searchUser(query: String): SearchUserResponse {
        return apiService.searchUser(query)
    }

    suspend fun getUserProfile() {
        return apiService.getUserProfile()
    }

    suspend fun getUserRepo() {
        return apiService.getUserRepo()
    }


}