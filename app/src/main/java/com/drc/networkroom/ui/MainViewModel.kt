package com.drc.networkroom.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.drc.networkroom.repository.DataBaseRepository
import com.drc.networkroom.repository.RetrofitRepository
import com.drc.networkroom.room.data.User
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor( val  dataBaseRepository: DataBaseRepository, val   retrofitRepository:
RetrofitRepository):ViewModel() {

    public var userlist:MutableLiveData<List<User>>

    init {
        userlist = MutableLiveData<List<User>>()
    }


     fun getuserfromserver(mainActivity: MainActivity) {

        retrofitRepository.getdatafromserver(userlist)

         userlist.observe(mainActivity, Observer {
                 viewModelScope.launch {
                     dataBaseRepository.insert_or_UpdateUserFromDB(it)
                 }

         })

    }



    fun getuserfromdb() {

        viewModelScope.launch {
            var  data =dataBaseRepository.getUserFromDB()
            userlist.postValue(data)

        }
    }

}