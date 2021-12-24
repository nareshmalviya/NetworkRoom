package com.drc.networkroom.room

import androidx.room.*
import com.drc.networkroom.room.data.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert_or_User(user: List<User>)
    @Delete
    suspend fun delete(user: User)
    @Query("SELECT * FROM user")
    suspend fun getUserLIst() : List<User>


}