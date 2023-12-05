package io.astronout.core.data.source.local.room

import androidx.room.TypeConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import io.astronout.core.domain.model.User

class UsersTypeConverter {

    private val moshi = Moshi.Builder().build()
    private val stringType = Types.newParameterizedType(List::class.java, String::class.java)
    private val stringAdapter = moshi.adapter<List<User>>(stringType)

    @TypeConverter
    fun stringToUsers(string: String): List<User> {
        return stringAdapter.fromJson(string).orEmpty()
    }

    @TypeConverter
    fun userToString(data: List<User>): String {
        return stringAdapter.toJson(data)
    }

}