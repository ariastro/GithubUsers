package io.astronout.core.domain.repository

import io.astronout.core.domain.model.User
import io.astronout.core.domain.model.UserDetails
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow

interface GithubRepository {

    fun searchGithubUsers(query: String): Flow<Resource<List<User>>>
    fun getUserDetails(username: String): Flow<Resource<UserDetails>>

}
