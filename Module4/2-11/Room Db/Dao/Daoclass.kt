package com.example.myapplication.Dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.myapplication.Entity.User




@Dao
interface Daoclass
{
    @Insert
    fun addUser(user: User?)


}