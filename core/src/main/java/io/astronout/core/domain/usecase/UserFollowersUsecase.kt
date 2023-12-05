package io.astronout.core.domain.usecase

import io.astronout.core.domain.model.User
import io.astronout.core.domain.repository.GithubRepository
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class UserFollowersUsecase @Inject constructor (
    private val repository: GithubRepository
): UseCase<String, Flow<Resource<List<User>>>> {
    override fun invoke(param: String): Flow<Resource<List<User>>> {
        return repository.getUserFollowers(username = param)
    }
}