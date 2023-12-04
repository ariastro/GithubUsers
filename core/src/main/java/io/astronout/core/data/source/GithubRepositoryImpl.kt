package io.astronout.core.data.source

import io.astronout.core.data.source.local.LocalDataSource
import io.astronout.core.data.source.remote.RemoteDataSource
import io.astronout.core.domain.repository.GithubRepository
import javax.inject.Inject

class GithubRepositoryImpl @Inject constructor(
    private val remoteDataSource: RemoteDataSource,
    private val localDataSource: LocalDataSource
) : GithubRepository {

}
