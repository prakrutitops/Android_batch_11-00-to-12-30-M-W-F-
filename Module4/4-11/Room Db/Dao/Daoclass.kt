package com.example.myapplication.Dao

import androidx.room.*
import com.example.myapplication.Entity.User


@Dao
interface Daoclass
{
    @Insert
    fun addUser(user: User?)

    @Query("select * from users")
    fun getUsers(): MutableList<User>

    @Delete
    fun deleteUser(user: User?)

    @Update
    fun updateUser(user: User?)

}