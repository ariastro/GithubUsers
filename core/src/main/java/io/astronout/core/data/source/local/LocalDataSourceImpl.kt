package io.astronout.core.data.source.local

import io.astronout.core.data.source.local.room.GithubDatabase
import javax.inject.Inject

class LocalDataSourceImpl @Inject constructor(
    private val appDatabase: GithubDatabase
) : LocalDataSource {

}