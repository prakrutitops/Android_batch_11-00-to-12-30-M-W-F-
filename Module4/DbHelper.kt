package com.example.sqlitedb

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.view.Display.Mode

class DbHelper(context: Context?) : SQLiteOpenHelper(context, DB_NAME, null, DB_VESRION)
{
    companion object
    {
        var DB_NAME="user.db"
        var TABLE_NAME="info"
        var ID="id"
        var NAME="name"
        var PASS="pass"
        var DB_VESRION=1
    }
    override fun onCreate(p0: SQLiteDatabase?)
    {
        var query ="CREATE TABLE " + TABLE_NAME + "("+ ID + " INTEGER PRIMARY KEY," + NAME + " TEXT,"+ PASS + " TEXT" + ")"
        p0!!.execSQL(query)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int)
    {
        var upquery ="DROP TABLE IF EXISTS "+ TABLE_NAME
        p0!!.execSQL(upquery)
        onCreate(p0)
    }

    fun insertdata(m:Model) :Long
    {
        var db = this.writableDatabase
        var contentValues =ContentValues()
        contentValues.put(NAME,m.name)
        contentValues.put(PASS,m.pass)
        var id =db.insert(TABLE_NAME, ID,contentValues)

        return id
    }

    fun viewdata():List<Model>
    {
        var db = this.readableDatabase
        var list:MutableList<Model> = ArrayList()
        var data =arrayOf(ID, NAME, PASS)
        var cursor:Cursor =db.query(TABLE_NAME,data,null,null,null,null,null)

        while (cursor.moveToNext())
        {
            var id1 =cursor.getInt(0)
            var name1 =cursor.getString(1)
            var pass1 =cursor.getString(2)

            var m =Model()
            m.id=id1
            m.name=name1
            m.pass=pass1

            list.add(m)

        }
        return list
    }

}