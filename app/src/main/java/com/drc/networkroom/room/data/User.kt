package com.drc.networkroom.room.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class User(
    @ColumnInfo(name = "name") var name:String,
    @ColumnInfo(name = "year")var year:Int,
    @ColumnInfo(name = "color")var color:String
) {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    var id:Int=0
}