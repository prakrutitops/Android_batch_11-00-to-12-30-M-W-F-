package com.example.recyclreviewcardviewex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

    lateinit var recycler: RecyclerView
    lateinit var list: MutableList<Model>

class MainActivity : AppCompatActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler = findViewById(R.id.recycler)
        list = ArrayList()

        var layout:RecyclerView.LayoutManager = GridLayoutManager(this,2)
        recycler.layoutManager =layout

        list.add(Model(R.drawable.icon,"Android"))
        list.add(Model(R.drawable.icon,"Java"))
        list.add(Model(R.drawable.icon,"Php"))
        list.add(Model(R.drawable.icon,"Ios"))

        var adapter =MyAdapter(applicationContext, list)
        recycler.adapter = adapter




    }
}