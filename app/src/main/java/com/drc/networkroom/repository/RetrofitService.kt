package com.drc.networkroom.repository



import com.drc.networkroom.model.UserLIstModel
import com.drc.networkroom.room.data.User

import retrofit2.Call
import retrofit2.http.*

interface RetrofitService {



    @GET
    fun getuserfromserver(@Url url:String): Call<UserLIstModel>?




}