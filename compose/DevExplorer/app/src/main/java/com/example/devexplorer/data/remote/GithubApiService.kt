package com.example.devexplorer.data.remote

import com.example.devexplorer.data.remote.dto.SearchUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GithubApiService {

    @GET("/search/users/")
    suspend fun searchUser(
        @Query("q") query: String = "all",
        @Query("page") page: Int = 1,
        @Query("per_page") perPage: Int = 20,
    ): SearchUserResponse

    @GET("/users/")
    suspend fun getUserProfile()

    @GET("/users/{username}/repos")
    suspend fun getUserRepo()
}