package com.example.myapplication.Adapter


import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import androidx.room.Room
import com.example.myapplication.Activity.AdduserActivity
import com.example.myapplication.Database.DatabaseClass
import com.example.myapplication.Entity.User
import com.example.myapplication.R
import com.example.myapplication.globalVariables.GlobalVariables


class UserAdapter(userList: MutableList<User>) : RecyclerView.Adapter<UserHolder?>()
{
    var userList: MutableList<User>
    var db: DatabaseClass? = null
    private var mContext: Context? = null

    init
    {
        this.userList = userList
    }

    @NonNull
    override fun onCreateViewHolder(@NonNull parent: ViewGroup, i: Int): UserHolder {
        mContext = parent.getContext()
        db = Room.databaseBuilder(parent.getContext(),
            DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.user_adapter, parent, false)
        return UserHolder(v)
    }

    override fun onBindViewHolder(@NonNull userHolder: UserHolder, position: Int)
    {
        userHolder.name.setText(userList[position].name.toString())
        userHolder.email.setText(userList[position].email.toString())

       userHolder.itemView.setOnClickListener{

           val alertDialog = AlertDialog.Builder(mContext).create()

           alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "Edit") { dialog, which ->
               dialog.dismiss()

               GlobalVariables.id = userList[position].id
               GlobalVariables.name = userList[position].name
               GlobalVariables.email = userList[position].email
               GlobalVariables.updateFlag = "update"

               val intent = Intent(mContext, AdduserActivity::class.java)
               mContext!!.startActivity(intent)
           }

           alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Delete") { dialog, which ->

               deleteUser(userList[position].id)
               dialog.dismiss()
               userList.removeAt(position)
               notifyItemRemoved(position)
               notifyItemRangeChanged(position, userList.size)

           }
           alertDialog.show()

       }
    }

    private fun deleteUser(id: Int)
    {
        val user = User()
        user.id = id
        db!!.daoClass().deleteUser(user)
        Toast.makeText(mContext, "Deleted!", Toast.LENGTH_SHORT).show()
    }

    override fun getItemCount(): Int
    {
        return userList.size
    }

    }
     class UserHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView)
    {
        val name: TextView
        val email: TextView

        init
        {
            name = itemView.findViewById<TextView>(R.id.name)
            email = itemView.findViewById<TextView>(R.id.email)
        }
    }
