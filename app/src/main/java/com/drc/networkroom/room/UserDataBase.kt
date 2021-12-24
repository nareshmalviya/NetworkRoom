package com.drc.networkroom.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.drc.networkroom.room.data.User

@Database(entities = [User::class],version = 1)
abstract class UserDataBase : RoomDatabase() {
    abstract val userDao:UserDao
}