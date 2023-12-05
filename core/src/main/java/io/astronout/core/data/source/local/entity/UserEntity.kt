package io.astronout.core.data.source.local.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
@Entity(tableName = "user")
data class UserEntity(
    @PrimaryKey
    val id: Int,
    @ColumnInfo(name = "login")
    val login: String,
    @ColumnInfo(name = "node_id")
    val nodeId: String,
    @ColumnInfo(name = "avatar_url")
    val avatarUrl: String,
    @ColumnInfo(name = "url")
    val url: String,
    @ColumnInfo(name = "type")
    val type: String,
)