package com.example.jsonexample

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context,var list: MutableList<Model>) :BaseAdapter()
{
    override fun getCount(): Int
    {
        return list.size
    }

    override fun getItem(p0: Int): Any {
      return p0
    }

    override fun getItemId(p0: Int): Long {
       return  p0.toLong()
    }

    @SuppressLint("MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View
    {
        var inflater=LayoutInflater.from(context)
        var view=inflater.inflate(R.layout.design,p2,false)
        var txt1:TextView=view.findViewById(R.id.txt1)
        var txt2:TextView=view.findViewById(R.id.txt2)
        var txt3:TextView=view.findViewById(R.id.txt3)
        var img1:ImageView=view.findViewById(R.id.img)
        var m = list.get(p0)
        txt1.setText(list.get(p0).product_name)
        txt2.setText(list.get(p0).product_price)
        txt3.setText(list.get(p0).product_description)
        Picasso.get().load(m.product_image).into(img1)
        return view
    }
}