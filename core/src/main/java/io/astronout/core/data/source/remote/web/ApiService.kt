package io.astronout.core.data.source.remote.web

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.data.source.remote.dto.UserDetailsResponse
import io.astronout.core.data.source.remote.dto.UserItem
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    suspend fun searchGithubUsers(
        @Query("q") query: String
    ): ApiResponse<GithubUserResponse>

    @GET("users/{username}")
    suspend fun getUserDetails(
        @Path("username") username: String
    ): ApiResponse<UserDetailsResponse>

    @GET("users/{username}/followers")
    suspend fun getFollowers(
        @Path("username") username: String
    ): ApiResponse<List<UserItem>>

    @GET("users/{username}/following")
    suspend fun getFollowing(
        @Path("username") username: String
    ): ApiResponse<List<UserItem>>

}