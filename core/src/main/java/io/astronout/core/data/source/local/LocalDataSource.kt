package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.entity.UserEntity
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {

    fun searchUsers(query: String): Flow<List<UserEntity>>
    fun getUserDetail(username: String): Flow<UserEntity?>
    suspend fun insertUsers(users: List<UserEntity>)
    
}