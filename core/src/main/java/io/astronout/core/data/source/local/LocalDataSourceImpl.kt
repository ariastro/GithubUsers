package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.UserDetailsEntity
import io.astronout.core.data.source.local.entity.UserEntity
import io.astronout.core.data.source.local.room.GithubDatabase
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: GithubDatabase
) : LocalDataSource {
    override fun searchUsers(query: String): Flow<List<UserEntity>> {
        return appDatabase.userDao().searchUsers(query)
    }

    override suspend fun insertUsers(users: List<UserEntity>) {
        appDatabase.userDao().insertUsers(users)
    }

    override suspend fun insertUserDetails(userDetailsEntity: UserDetailsEntity) {
        appDatabase.userDetailsDao().insertUserDetails(userDetailsEntity)
    }

    override fun getUserDetail(username: String): Flow<UserDetailsEntity?> {
        return appDatabase.userDetailsDao().getUserDetails(username)
    }

    override suspend fun updateUserFollowers(username: String, followers: List<UserEntity>) {
        return appDatabase.userDetailsDao().updateFollowers(username, followers)
    }

    override suspend fun updateUserFollowings(username: String, followings: List<UserEntity>) {
        return appDatabase.userDetailsDao().updateFollowings(username, followings)
    }

}