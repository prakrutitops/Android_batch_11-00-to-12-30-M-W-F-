package com.example.retrofitex

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call

class MyAdapter(var context: Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(context)
        var view = inflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)
    }

    override fun getItemCount(): Int
    {
       return list.size
    }

}
class MyView(itemView: View) :RecyclerView.ViewHolder(itemView)
{
    var txt1:TextView = itemView.findViewById(R.id.txt1)
    var txt2:TextView = itemView.findViewById(R.id.txt2)
}