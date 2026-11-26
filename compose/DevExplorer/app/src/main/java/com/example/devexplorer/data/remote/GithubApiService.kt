package com.example.devexplorer.data.remote

import com.example.devexplorer.data.remote.dto.GitHubProfileDto
import com.example.devexplorer.data.remote.dto.GitHubRepoDto
import com.example.devexplorer.data.remote.dto.GitHubUserDto
import com.example.devexplorer.data.remote.dto.SearchUserResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApiService {

    @GET("search/users")
    suspend fun searchUser(
        @Query("q") query: String = "all",
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20,
    ): SearchUserResponse

    @GET("users/{username}")
    suspend fun getUserProfile(
        @Path("username") userName: String
    ): GitHubProfileDto

    @GET("users/{username}/repo")
    suspend fun getUserRepo(
        @Path("username") userName: String
    ): List<GitHubRepoDto>


}