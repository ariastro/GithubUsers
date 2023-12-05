package io.astronout.core.data.source

import com.skydoves.sandwich.ApiResponse
import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.mapper.toDomain
import io.astronout.core.data.source.mapper.toEntity
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.domain.model.User
import io.astronout.core.domain.repository.GithubRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
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

}
