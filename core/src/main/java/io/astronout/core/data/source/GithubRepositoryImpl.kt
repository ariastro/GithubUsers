package io.astronout.core.data.source

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.mapper.toDomain
import io.astronout.core.data.source.mapper.toEntity
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.data.source.remote.dto.UserDetailsResponse
import io.astronout.core.data.source.remote.dto.UserItemResponse
import io.astronout.core.domain.model.User
import io.astronout.core.domain.model.UserDetails
import io.astronout.core.domain.repository.GithubRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : GithubRepository {

    override fun searchGithubUsers(query: String): Flow<Resource<List<User>>> =
        object : NetworkBoundResource<List<User>, GithubUserResponse>() {
            override fun loadFromDB(): Flow<List<User>> {
                return localDataSource.searchUsers(query).map { users ->
                    users.toDomain()
                }
            }

            override fun shouldFetch(data: List<User>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): ApiResponse<GithubUserResponse> =
                remoteDataSource.searchGithubUsers(query)

            override suspend fun saveCallResult(data: GithubUserResponse) {
                localDataSource.insertUsers(data.toEntity())
            }
        }.asFlow()

    override fun getUserDetails(username: String): Flow<Resource<UserDetails>> =
        object : NetworkBoundResource<UserDetails, UserDetailsResponse>() {
            override fun loadFromDB(): Flow<UserDetails> {
                return localDataSource.getUserDetail(username).map {
                    it.toDomain()
                }
            }

            override fun shouldFetch(data: UserDetails?): Boolean =
                data == null

            override suspend fun createCall(): ApiResponse<UserDetailsResponse> =
                remoteDataSource.getUserDetails(username)

            override suspend fun saveCallResult(data: UserDetailsResponse) {
                localDataSource.insertUserDetails(data.toEntity())
            }
        }.asFlow()

    override fun getUserFollowers(username: String): Flow<Resource<List<User>>> =
        object : NetworkBoundResource<List<User>, List<UserItemResponse>>() {
            override fun loadFromDB(): Flow<List<User>> {
                return localDataSource.getUserDetail(username).map { it?.followerList.orEmpty() }
            }

            override fun shouldFetch(data: List<User>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): ApiResponse<List<UserItemResponse>> =
                remoteDataSource.getFollowers(username)

            override suspend fun saveCallResult(data: List<UserItemResponse>) {
                localDataSource.updateUserFollowers(username, data.toEntity())
            }
        }.asFlow()

    override fun getUserFollowings(username: String): Flow<Resource<List<User>>> =
        object : NetworkBoundResource<List<User>, List<UserItemResponse>>() {
            override fun loadFromDB(): Flow<List<User>> {
                return localDataSource.getUserDetail(username).map { it?.followerList.orEmpty() }
            }

            override fun shouldFetch(data: List<User>?): Boolean =
                data.isNullOrEmpty()

            override suspend fun createCall(): ApiResponse<List<UserItemResponse>> =
                remoteDataSource.getFollowing(username)

            override suspend fun saveCallResult(data: List<UserItemResponse>) {
                localDataSource.updateUserFollowers(username, data.toEntity())
            }
        }.asFlow()

}
