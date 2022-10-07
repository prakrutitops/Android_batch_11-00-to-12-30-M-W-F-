package com.example.extra1

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView

class DashBoardActivity : AppCompatActivity()
{
    lateinit var txt1:TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btn1:Button

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dash_board)

        txt1 = findViewById(R.id.txt1)
        sharedPreferences = getSharedPreferences("USER_SESSION",Context.MODE_PRIVATE)
        btn1 = findViewById(R.id.btn1)

        txt1.setText("Welcome "+sharedPreferences.getString("NAME","De"))

        btn1.setOnClickListener {

            sharedPreferences.edit().clear().commit()
            var i =Intent(this,LoginActivity::class.java)
            startActivity(i)
            finish()
        }

    }
}