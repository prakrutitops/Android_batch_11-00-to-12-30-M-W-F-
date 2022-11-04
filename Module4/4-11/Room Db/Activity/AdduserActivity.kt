package com.example.myapplication.Activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.example.myapplication.Database.DatabaseClass
import com.example.myapplication.Entity.User
import com.example.myapplication.MainActivity
import com.example.myapplication.R
import com.example.myapplication.globalVariables.GlobalVariables


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

            if (GlobalVariables.updateFlag.equals("update"))
            {
                edt1.setText(GlobalVariables.name)
                edt2.setText(GlobalVariables.email)
            }

            btn1.setOnClickListener{

                var name1 =edt1.text.toString()
                var email1 = edt2.text.toString()


                if (name1.length>0 && email1.length>0)
                {


                    if (GlobalVariables.updateFlag.equals("update"))
                    {
                       var u = User()
                        u.id=GlobalVariables.id
                        u.name=name1
                        u.email=email1

                        db!!.daoClass().updateUser(u)
                        Toast.makeText(mContext, "Successful", Toast.LENGTH_SHORT).show();
                        GlobalVariables.updateFlag = "";

                        startActivity(Intent(this,MainActivity::class.java))
                    }

                else
                    {
                        var u = User()
                        u.name = name1
                        u.email=email1

                        db!!.daoClass().addUser(u)
                        Toast.makeText(mContext, "Successful", Toast.LENGTH_SHORT).show()
                        var i =Intent(this,MainActivity::class.java)
                        startActivity(i)
                    }

                }

            }
        }
}
