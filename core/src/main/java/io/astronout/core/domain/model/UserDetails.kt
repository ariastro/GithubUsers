package io.astronout.core.domain.model

data class UserDetails(
    val id: Int,
    val login: String,
    val avatarUrl: String,
    val gravatarId: String,
    val type: String,
    val name: String,
    val company: String,
    val blog: String,
    val location: String,
    val email: Any,
    val bio: String,
    val publicRepos: Int,
    val publicGists: Int,
    val followers: Int,
    val following: Int,
    val createdAt: String,
    val updatedAt: String,
    val followerList: List<User>,
    val followingList: List<User>
)