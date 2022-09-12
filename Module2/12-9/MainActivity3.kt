package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity3 : AppCompatActivity()
{
    lateinit var txt1:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        var i = intent
        var data = i.getStringExtra("Bill")
        txt1=findViewById(R.id.txt1)
        txt1.setText(data)


    }
    override fun onBackPressed()
    {
        finishAffinity()
    }
}