package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.UserDetailsEntity
import io.astronout.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun searchUsers(query: String): Flow<List<UserEntity>>
    suspend fun insertUsers(users: List<UserEntity>)
    suspend fun insertUserDetails(userDetailsEntity: UserDetailsEntity)
    fun getUserDetail(username: String): Flow<UserDetailsEntity?>
    suspend fun updateUserFollowers(username: String, followers: List<UserEntity>)
    suspend fun updateUserFollowings(username: String, followings: List<UserEntity>)

}