package io.astronout.core.data.source.remote.dto

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GithubUserResponse(
    @Json(name = "total_count")
    val totalCount: Int? = null,
    @Json(name = "incomplete_results")
    val incompleteResults: Boolean? = null,
    @Json(name = "items")
    val items: List<UserItem>? = null
)