package io.astronout.core.data.source.remote.web

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("search/users")
    suspend fun searchGithubUsers(
        @Query("q") query: String
    ): ApiResponse<GithubUserResponse>

}