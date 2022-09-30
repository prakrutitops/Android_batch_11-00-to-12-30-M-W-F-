package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.Button

class MainActivity : AppCompatActivity()
{

    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        animatedata()
        btn1.setOnClickListener {


        }

    }

    private fun animatedata()
    {
        var animation:Animation = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        btn1.startAnimation(animation)

    }
}