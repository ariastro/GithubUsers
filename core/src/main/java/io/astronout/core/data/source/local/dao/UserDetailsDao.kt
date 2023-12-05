package io.astronout.core.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.astronout.core.data.source.local.entity.UserDetailsEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDetailsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUserDetails(userDetails: UserDetailsEntity)

    @Query("SELECT * FROM user_details WHERE login = :username")
    fun getUserDetails(username: String): Flow<UserDetailsEntity?>
}