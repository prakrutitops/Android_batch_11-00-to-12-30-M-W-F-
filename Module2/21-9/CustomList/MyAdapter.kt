package com.example.customlist

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(var context: Context, var list: MutableList<Model>) : BaseAdapter()
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
        var layout =LayoutInflater.from(context)
        var view=layout.inflate(R.layout.design,p2,false)

        var image:ImageView=view.findViewById(R.id.img)
        var name:TextView=view.findViewById(R.id.txtname)
        var des:TextView=view.findViewById(R.id.txtdes)

        name.setText(list.get(p0).name)
        des.setText(list.get(p0).des)
        image.setImageResource(list.get(p0).image)



        return view
    }


}