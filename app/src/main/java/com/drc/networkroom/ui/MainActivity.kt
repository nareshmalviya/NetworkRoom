package com.drc.networkroom.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.drc.networkroom.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainViewModel: MainViewModel
    lateinit var userAdapter: UserAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        //https://reqres.in/api/unknown

        userAdapter = UserAdapter()
        binding.cityList.adapter = userAdapter

        mainViewModel.getuserfromdb()
        mainViewModel.getuserfromserver(this)

        mainViewModel.userlist.observe(this@MainActivity, Observer {

            userAdapter.setdata(it,this@MainActivity)
            userAdapter.notifyDataSetChanged()
        })


    }
}