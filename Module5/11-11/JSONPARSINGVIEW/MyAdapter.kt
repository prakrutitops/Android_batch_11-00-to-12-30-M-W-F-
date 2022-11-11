package com.example.jsonparsingex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso

class MyAdapter(var context: Context,var list: MutableList<Model>) :RecyclerView.Adapter<Myview>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Myview
    {
        var layout =LayoutInflater.from(context)
        var view =layout.inflate(R.layout.design,parent,false)
        return Myview(view)
    }

    override fun onBindViewHolder(holder: Myview, position: Int)
    {
            holder.txt1.setText(list.get(position).name)
            Picasso.get().load(list.get(position).image).placeholder(R.drawable.icon).error(R.mipmap.ic_launcher).into(holder.img1)
    }

    override fun getItemCount(): Int {
            return list.size
    }

}
class Myview(itemview: View) :RecyclerView.ViewHolder(itemview)
{
        var txt1:TextView = itemview.findViewById(R.id.txt)
        var img1:ImageView=itemview.findViewById(R.id.img)

}