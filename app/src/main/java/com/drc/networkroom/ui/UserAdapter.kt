package com.drc.networkroom.ui

import android.content.Intent
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.drc.networkroom.R
import com.drc.networkroom.databinding.UserItemBinding
import com.drc.networkroom.room.data.User


class UserAdapter : RecyclerView.Adapter<UserAdapter.UpdatesDataHolder>() {

    private   var  userList : List<User>? = null
    private   var  activity: MainActivity? = null

    fun  setdata(userListdata: List<User>?, activity: MainActivity?){
        this.userList=userListdata
        this.activity=activity
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UpdatesDataHolder {

        var view :View = LayoutInflater.from(parent.context).inflate(R.layout.user_item,parent,false)
        var _binding = UserItemBinding.bind(view)
        return UpdatesDataHolder(_binding)

    }

    override fun onBindViewHolder(holder: UpdatesDataHolder, position: Int) {

        holder.bind(userList?.get(position))
    }

    override fun getItemCount(): Int {
        if (userList==null)
            return 0
       return userList?.size!!
    }


  inner  class UpdatesDataHolder(val _binding: UserItemBinding) : RecyclerView.ViewHolder(_binding.root){
      fun bind(city: User?) {
          _binding.name.text = city!!.name
          _binding.year.text = city!!.year.toString()

          _binding.name.setTextColor(Color.parseColor(city!!.color))
          _binding.year.setTextColor(Color.parseColor(city!!.color))


      }
  }
}