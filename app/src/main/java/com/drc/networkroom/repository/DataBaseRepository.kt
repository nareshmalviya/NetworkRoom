package com.drc.networkroom.repository

import com.drc.networkroom.room.UserDao
import com.drc.networkroom.room.data.User
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class DataBaseRepository @Inject constructor(private val userDao: UserDao) {


    suspend  fun getUserFromDB():List<User> {

        return userDao.getUserLIst()
    }


  suspend  fun insert_or_UpdateUserFromDB(user: List<User>) {

        userDao.insert_or_User(user)
    }

    suspend  fun deleteUserFromDB(user: User) {

        userDao.delete(user)
    }

}