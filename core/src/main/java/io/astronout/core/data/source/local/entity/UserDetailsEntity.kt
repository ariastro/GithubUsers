package io.astronout.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_details")
data class UserDetailsEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
    @ColumnInfo(name = "gravatar_id")
    val gravatarId: String,
    @ColumnInfo(name = "type")
    val type: String,
    @ColumnInfo(name = "name")
    val name: String,
    @ColumnInfo(name = "company")
    val company: String,
    @ColumnInfo(name = "blog")
    val blog: String,
    @ColumnInfo(name = "location")
    val location: String,
    @ColumnInfo(name = "email")
    val email: String,
    @ColumnInfo(name = "bio")
    val bio: String,
    @ColumnInfo(name = "public_repos")
    val publicRepos: Int,
    @ColumnInfo(name = "public_gists")
    val publicGists: Int,
    @ColumnInfo(name = "followers")
    val followers: Int,
    @ColumnInfo(name = "following")
    val following: Int,
    @ColumnInfo(name = "created_at")
    val createdAt: String,
    @ColumnInfo(name = "updated_at")
    val updatedAt: String,
    @ColumnInfo(name = "follower_list")
    val followerList: List<UserEntity>,
    @ColumnInfo(name = "following_list")
    val followingList: List<UserEntity>
)