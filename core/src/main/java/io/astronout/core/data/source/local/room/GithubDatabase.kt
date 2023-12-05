package io.astronout.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import io.astronout.core.data.source.local.dao.UserDao
import io.astronout.core.data.source.local.dao.UserDetailsDao
import io.astronout.core.data.source.local.entity.UserDetailsEntity
import io.astronout.core.data.source.local.entity.UserEntity

@Database(
    entities = [UserEntity::class, UserDetailsEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(StringTypeConverter::class, DateTypeConverter::class)
abstract class GithubDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun userDetailsDao(): UserDetailsDao
}