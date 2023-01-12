package com.example.firstapp.Adapter

import androidx.recyclerview.widget.RecyclerView
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.example.firstapp.Activity.CategoryActivity
import com.example.firstapp.Activity.FullScreenActivity
import com.example.firstapp.Model.Category_Model
import com.example.firstapp.Model.Dashboard_Model
import com.example.firstapp.R
import com.squareup.picasso.Picasso


class CategoryAdapter(var context: Context,var list: MutableList<Category_Model>) :RecyclerView.Adapter<MyView2>()
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView2 {

        var inflater =LayoutInflater.from(context)
        var view =inflater.inflate(R.layout.design_category,parent,false)
        return MyView2(view)

    }

    override fun onBindViewHolder(holder: MyView2, position: Int)
    {

        Picasso.get().load(list.get(position).image).into(holder.img1)

        holder.itemView.setOnClickListener {


            var i = Intent(context, FullScreenActivity::class.java)
            i.putExtra("f_pos",list.get(position).image)
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            context.startActivity(i)
        }



    }

    override fun getItemCount(): Int
    {
        return list.size
    }
}
class MyView2(itemview: View) : RecyclerView.ViewHolder(itemview)
{

    var img1:ImageView = itemview.findViewById(R.id.category_img)
}