package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.UserEntity
import io.astronout.core.data.source.local.room.GithubDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: GithubDatabase
) : LocalDataSource {
    override fun searchUsers(query: String): Flow<List<UserEntity>> {
        return appDatabase.githubDao().searchUsers(query)
    }

    override fun getUserDetail(username: String): Flow<UserEntity?> {
        return appDatabase.githubDao().getUserDetails(username)
    }

    override suspend fun insertUsers(users: List<UserEntity>) {
        appDatabase.githubDao().insertUsers(users)
    }

}