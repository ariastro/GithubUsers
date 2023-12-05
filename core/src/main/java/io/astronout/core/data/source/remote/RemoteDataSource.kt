package io.astronout.core.data.source.remote

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.data.source.remote.dto.UserDetailsResponse
import io.astronout.core.data.source.remote.dto.UserItem
import io.astronout.core.data.source.remote.web.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiService) : ApiService {

    override suspend fun searchGithubUsers(query: String): ApiResponse<GithubUserResponse> {
        return api.searchGithubUsers(query)
    }

    override suspend fun getUserDetails(username: String): ApiResponse<UserDetailsResponse> {
        return api.getUserDetails(username)
    }

    override suspend fun getFollowers(username: String): ApiResponse<List<UserItem>> {
        return api.getFollowers(username)
    }

    override suspend fun getFollowing(username: String): ApiResponse<List<UserItem>> {
        return api.getFollowing(username)
    }

}

