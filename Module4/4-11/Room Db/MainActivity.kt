package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.Activity.AdduserActivity
import com.example.myapplication.Adapter.UserAdapter
import com.example.myapplication.Database.DatabaseClass
import com.example.myapplication.Entity.User
import com.google.android.material.floatingactionbutton.FloatingActionButton


class MainActivity : AppCompatActivity()
{
    lateinit var fl1:FloatingActionButton
    lateinit var recyclerView: RecyclerView
    lateinit var list: MutableList<User>
    var db: DatabaseClass? = null
    var mAdapter: UserAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        list = ArrayList()

        var l1:RecyclerView.LayoutManager =LinearLayoutManager(this)
        recyclerView.layoutManager=l1
        db = Room.databaseBuilder(applicationContext,
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()

        getalldata()

        fl1 = findViewById(R.id.fab)
        fl1.setOnClickListener {

                var i =Intent(this, AdduserActivity::class.java)
                startActivity(i)

        }
    }

    private fun getalldata()
    {
            list = db!!.daoClass().getUsers()

        if (list.size > 0)
        {
            mAdapter =  UserAdapter(list)
            recyclerView.setAdapter(mAdapter)

        }
        else
        {
            Toast.makeText(this, "No data ", Toast.LENGTH_SHORT).show();
        }
    }
}