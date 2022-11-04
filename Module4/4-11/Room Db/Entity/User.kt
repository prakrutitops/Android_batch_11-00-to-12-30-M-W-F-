package com.example.myapplication.Entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "users")
class User
{
    @PrimaryKey(autoGenerate = true)
     var id = 0

    @ColumnInfo(name = "user_name")
     var name: String? = null

    @ColumnInfo(name = "user_email")
     var email: String? = null


}