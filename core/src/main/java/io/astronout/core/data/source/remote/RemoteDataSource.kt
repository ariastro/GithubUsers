package io.astronout.core.data.source.remote

import io.astronout.core.data.source.remote.web.ApiService
import javax.inject.Inject

class RemoteDataSource @Inject constructor(private val api: ApiService) : ApiService {


}

