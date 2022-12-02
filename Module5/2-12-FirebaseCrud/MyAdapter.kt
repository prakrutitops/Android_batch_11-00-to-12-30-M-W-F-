package com.example.firebasecrudapp


import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase


class MyAdapter(options: FirebaseRecyclerOptions<Model>) : FirebaseRecyclerAdapter<Model, myviewholder>(options)
{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): myviewholder
    {
        val view: View = LayoutInflater.from(parent.getContext()).inflate(R.layout.design, parent, false)
        return myviewholder(view)
    }

    override fun onBindViewHolder(holder: myviewholder, position: Int, model: Model)
    {
        holder.name.setText(model.n1)
        holder.email.setText(model.e1)
        holder.pass.setText(model.p1)

        holder.delete.setOnClickListener {

                    var alert = AlertDialog.Builder(holder.delete.context)
                    alert.setTitle("DELETE?")
                    alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

                        FirebaseDatabase.getInstance().getReference().child("android1")
                            .child(getRef(position).getKey()!!)
                            .removeValue()

                        notifyItemRangeChanged(position,0)

                    })
                    alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                        dialogInterface.cancel()
                    })
                 alert.show()



        }

    }

}
class myviewholder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var name: TextView
    var pass: TextView
    var email: TextView
    var edit: ImageView
    var delete: ImageView

    init
    {

        name = itemView.findViewById(R.id.txt1)
        email = itemView.findViewById(R.id.txt2)
        pass = itemView.findViewById(R.id.txt3)
        edit = itemView.findViewById(R.id.edit)
        delete = itemView.findViewById(R.id.delete)

    }
}
