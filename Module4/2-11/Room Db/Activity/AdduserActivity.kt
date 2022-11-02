package com.example.myapplication.Activity

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.Database.DatabaseClass
import com.example.myapplication.Entity.User
import com.example.myapplication.R


class AdduserActivity : AppCompatActivity()
{

        lateinit var edt1:EditText
        lateinit var edt2:EditText
        lateinit var btn1:Button
        var db: DatabaseClass? = null
        var mContext: Context? = null
        override fun onCreate(savedInstanceState: Bundle?)
        {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_adduser)

            edt1 = findViewById(R.id.edt1)
            edt2 = findViewById(R.id.edt2)
            btn1 = findViewById(R.id.btn1)
            mContext = this

            db = Room.databaseBuilder(applicationContext,
                DatabaseClass::class.java, "myDatabase").allowMainThreadQueries().build()
            // db = Room.databaseBuilder(applicationContext, DatabaseClass::class.java, "laptops").build()

            btn1.setOnClickListener {

                var name1 =edt1.text.toString()
                var email1 = edt2.text.toString()


                var u = User()
                u.name = name1
                u.email=email1

                db!!.daoClass().addUser(u)
                Toast.makeText(mContext, "Successful", Toast.LENGTH_SHORT).show()




            }

        }
}