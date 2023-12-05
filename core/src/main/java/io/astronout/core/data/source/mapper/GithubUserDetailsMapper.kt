package io.astronout.core.data.source.mapper

import io.astronout.core.data.source.local.entity.UserDetailsEntity
import io.astronout.core.data.source.local.entity.UserEntity
import io.astronout.core.data.source.remote.dto.GithubUserResponse
import io.astronout.core.data.source.remote.dto.UserDetailsResponse
import io.astronout.core.domain.model.User
import io.astronout.core.domain.model.UserDetails

fun UserDetailsResponse.toEntity(): UserDetailsEntity {
    return UserDetailsEntity(
        id = id ?: 0,
        login = login.orEmpty(),
        avatarUrl = avatarUrl.orEmpty(),
        gravatarId = gravatarId.orEmpty(),
        type = type.orEmpty(),
        name = name.orEmpty(),
        company = company.orEmpty(),
        blog = blog.orEmpty(),
        location = location.orEmpty(),
        email = email.orEmpty(),
        bio = bio.orEmpty(),
        publicRepos = publicRepos ?: 0,
        publicGists = publicGists ?: 0,
        followers = followers ?: 0,
        following = following ?: 0,
        createdAt = createdAt.orEmpty(),
        updatedAt = updatedAt.orEmpty(),
        followerList = emptyList(),
        followingList = emptyList()
    )
}

fun UserDetailsEntity?.toDomain(): UserDetails {
    return UserDetails(
        id = this?.id ?: 0,
        login = this?.login.orEmpty(),
        avatarUrl = this?.avatarUrl.orEmpty(),
        gravatarId = this?.gravatarId.orEmpty(),
        type = this?.type.orEmpty(),
        name = this?.name.orEmpty(),
        company = this?.company.orEmpty(),
        blog = this?.blog.orEmpty(),
        location = this?.location.orEmpty(),
        email = this?.email.orEmpty(),
        bio = this?.bio.orEmpty(),
        publicRepos = this?.publicRepos ?: 0,
        publicGists = this?.publicGists ?: 0,
        followers = this?.followers ?: 0,
        following = this?.following ?: 0,
        createdAt = this?.createdAt.orEmpty(),
        updatedAt = this?.updatedAt.orEmpty(),
        followerList = this?.followerList?.toDomain().orEmpty(),
        followingList = this?.followingList?.toDomain().orEmpty()
    )
}