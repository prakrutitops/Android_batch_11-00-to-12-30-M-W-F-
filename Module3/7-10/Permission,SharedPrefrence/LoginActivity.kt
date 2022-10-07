package com.example.extra1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btn1)
        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)

        if(sharedPreferences.getBoolean("USER_SESSION",false) && !sharedPreferences.getString("NAME","")!!.isEmpty())
        {
            startActivity(Intent(this,DashBoardActivity::class.java))
            finish()
        }

        btn1.setOnClickListener {

            var name =edt1.text.toString()
            var pass = edt2.text.toString()

            if(pass.equals("1234"))
            {
                var i =Intent(this,DashBoardActivity::class.java)
                sharedPreferences.edit().putString("NAME",name).commit()
                sharedPreferences.edit().putBoolean("USER_SESSION",true).commit()
                startActivity(i)
                finish()


            }
            else
            {
                Toast.makeText(applicationContext,"Wrong Credentials",Toast.LENGTH_LONG).show()
            }

        }

    }
}