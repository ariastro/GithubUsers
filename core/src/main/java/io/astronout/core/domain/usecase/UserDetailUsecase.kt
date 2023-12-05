package io.astronout.core.domain.usecase

import io.astronout.core.domain.model.UserDetails
import io.astronout.core.domain.repository.GithubRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserDetailUsecase @Inject constructor (
    private val repository: GithubRepository
): UseCase<String, Flow<Resource<UserDetails>>> {
    override fun invoke(param: String): Flow<Resource<UserDetails>> {
        return repository.getUserDetails(username = param)
    }
}