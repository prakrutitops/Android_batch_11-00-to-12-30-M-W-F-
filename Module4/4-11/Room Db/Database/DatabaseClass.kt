package com.example.myapplication.Database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.Dao.Daoclass
import com.example.myapplication.Entity.User

@Database(entities = [User::class], version = 1)
abstract class DatabaseClass : RoomDatabase()
{
    abstract fun daoClass(): Daoclass
}