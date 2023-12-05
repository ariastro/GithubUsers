package io.astronout.core.data.source.local.room

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.astronout.core.data.source.local.entity.UserEntity

class UsersTypeConverter {

    private val moshi = Moshi.Builder().build()
    private val userType = Types.newParameterizedType(List::class.java, UserEntity::class.java)
    private val userAdapter = moshi.adapter<List<UserEntity>>(userType)

    @TypeConverter
    fun stringToUsers(string: String): List<UserEntity> {
        return userAdapter.fromJson(string).orEmpty()
    }

    @TypeConverter
    fun userToString(data: List<UserEntity>): String {
        return userAdapter.toJson(data)
    }

}