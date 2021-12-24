package com.drc.networkroom.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.drc.networkroom.repository.RetrofitService
import com.drc.networkroom.room.UserDao
import com.drc.networkroom.room.UserDataBase

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UserModule {

    var baseUrl:String = "https://reqres.in/"


    @Provides
    @Singleton
    fun provideRoomDatabase(application: Application):UserDataBase{
        return Room.databaseBuilder(application,UserDataBase::class.java,"user_db").build()
    }

    @Provides
    @Singleton
    fun provideUserDao(userDataBase: UserDataBase):UserDao{
        return userDataBase.userDao
    }

    @Provides
    @Singleton
    fun provideRetrofit():Retrofit{
        return Retrofit.Builder().baseUrl(baseUrl).addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun getRetrofitService(retrofit: Retrofit): RetrofitService {
        return  retrofit.create(RetrofitService::class.java)
    }



}