package com.drc.networkroom.repository

import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.drc.networkroom.model.UserLIstModel
import com.drc.networkroom.room.data.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class RetrofitRepository @Inject constructor(val retrofitService: RetrofitService) {



     fun getdatafromserver(userlist: MutableLiveData<List<User>>) {
        val call =  retrofitService.getuserfromserver("https://reqres.in/api/unknown")
        call?.enqueue(object : Callback<UserLIstModel> {
            override fun onResponse(call: Call<UserLIstModel>, response: Response<UserLIstModel>) {
                if (response.isSuccessful){

                    userlist.postValue(response.body()?.data)
                }else{
                    userlist.postValue(null)
                }
                Log.e("dataget",response.body().toString())
            }
            override fun onFailure(call: Call<UserLIstModel>, t: Throwable) {
                userlist.postValue(null)
                Log.e("dataget",t.message.toString())
            }

        })


    }



}