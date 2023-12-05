package io.astronout.core.data.source.mapper

import io.astronout.core.data.source.local.entity.UserEntity
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.domain.model.User

fun GithubUserResponse.toEntity(): List<UserEntity> {
    return items?.map {
        UserEntity(
            login = it.login.orEmpty(),
            id = it.id ?: 0,
            nodeId = it.nodeId.orEmpty(),
            avatarUrl = it.avatarUrl.orEmpty(),
            type = it.type.orEmpty(),
            url = it.htmlUrl.orEmpty()
        )
    }.orEmpty()
}

fun List<UserEntity>.toDomain(): List<User> {
    return map {
        User(
            login = it.login,
            id = it.id,
            nodeId = it.nodeId,
            avatarUrl = it.avatarUrl,
            type = it.type,
            url = it.url
        )
    }
}