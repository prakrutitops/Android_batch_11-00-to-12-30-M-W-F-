package com.example.layoutex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView

class CustomEx : AppCompatActivity()
{
    lateinit var linearLayout: LinearLayout
    lateinit var text:TextView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        linearLayout= LinearLayout(applicationContext)
        text= TextView(applicationContext)
        text.setText("Hello World")

        var width=500
        var height=500

        linearLayout.addView(text,width,height)
        setContentView(linearLayout)
    }
}