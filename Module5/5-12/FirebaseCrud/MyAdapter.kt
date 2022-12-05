package com.example.firebasecrudapp


import android.content.DialogInterface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.annotation.NonNull
import androidx.appcompat.app.AlertDialog
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase
import com.orhanobut.dialogplus.DialogPlus
import com.orhanobut.dialogplus.ViewHolder


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

        holder.edit.setOnClickListener {
            val dialogPlus = DialogPlus.newDialog(holder.edit.context)
                .setContentHolder(ViewHolder(R.layout.dialogcontent))
                .setExpanded(true, 1100)
                .create()
            val myview = dialogPlus.holderView
            val name = myview.findViewById<EditText>(R.id.uname)
            val pass = myview.findViewById<EditText>(R.id.ucourse)
            val email = myview.findViewById<EditText>(R.id.uemail)
            val submit = myview.findViewById<Button>(R.id.usubmit)

            name.setText(model.n1)
            pass.setText(model.p1)
            email.setText(model.e1)

            dialogPlus.show()

            submit.setOnClickListener {

                val map: MutableMap<String, Any> = HashMap()
                map["n1"] = name.text.toString()
                map["e1"] = email.text.toString()
                map["p1"] = pass.text.toString()
                FirebaseDatabase.getInstance().getReference().child("android1")
                    .child(getRef(position).key!!).updateChildren(map)
                    .addOnSuccessListener {

                        Toast.makeText(holder.edit.context, "updated", Toast.LENGTH_SHORT).show()
                    }
                    .addOnFailureListener()
                    {
                        Toast.makeText(holder.edit.context, "Fail", Toast.LENGTH_SHORT).show()
                    }

            }





        }

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
