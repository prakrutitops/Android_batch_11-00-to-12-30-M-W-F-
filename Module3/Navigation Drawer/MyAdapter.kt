package com.example.navigationexample

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView

class MyAdapter(var context: Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any
    {
        return p0
    }

    override fun getItemId(p0: Int): Long
    {
        return p0.toLong()
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var inflater=LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design,p2,false)

        var txt :TextView =view.findViewById(R.id.txt1)

        txt.setText(list.get(p0).text)

        return view
    }

}