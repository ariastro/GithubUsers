package io.astronout.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.astronout.core.data.source.local.dao.GithubUserDao
import io.astronout.core.data.source.local.entity.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringTypeConverter::class, DateTypeConverter::class)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun githubDao(): GithubUserDao
}