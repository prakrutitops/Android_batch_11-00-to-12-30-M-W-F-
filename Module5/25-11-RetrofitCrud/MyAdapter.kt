package com.example.retrofitex


import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MyAdapter(var context: Context,var list:MutableList<Model>) :RecyclerView.Adapter<MyView>()
{
   lateinit var api:Apiinterface
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView
    {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.design,parent,false)
        return MyView(view)
    }

    override fun onBindViewHolder(holder: MyView, position: Int)
    {
        holder.txt1.setText(list.get(position).product_name)
        holder.txt2.setText(list.get(position).product_price)

        holder.itemView.setOnClickListener { v->

            val alert = AlertDialog.Builder(holder.txt1.context)
            alert.setTitle("Select Operation?")
            alert.setPositiveButton("Update",{ dialogInterface: DialogInterface, i: Int ->

                    var i =Intent(context,UpdateActivity::class.java)
                    i.putExtra("id",list.get(position).product_id)
                    i.putExtra("name",list.get(position).product_name)
                    i.putExtra("price",list.get(position).product_price)
                    i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
                    context.startActivity(i)



            })
            alert.setNegativeButton("Delete",{ dialogInterface: DialogInterface, i: Int ->

                api = ApiClient.getapiclient().create(Apiinterface::class.java)
                var call: Call<Model?>?=api.deletedata(list.get(position).product_id)
                call!!.enqueue(object :Callback<Model?>{
                    override fun onResponse(call: Call<Model?>, response: Response<Model?>) {


                        Toast.makeText(v.getContext(), "deleted ", Toast.LENGTH_SHORT).show()

                        val i = Intent()
                        i.flags = Intent.FLAG_ACTIVITY_NEW_TASK



                    }

                    override fun onFailure(call: Call<Model?>, t: Throwable) {

                    }
                })
                v.context.startActivity(Intent(v.context, MainActivity2::class.java))

            })
            alert.show()


        }
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