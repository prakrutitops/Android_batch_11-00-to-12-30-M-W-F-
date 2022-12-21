package com.quint.sensorex

import android.graphics.drawable.AnimationDrawable
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class FrameByFrameEx : AppCompatActivity()
{
    lateinit var animationDrawable: AnimationDrawable
    lateinit var imageView: ImageView
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_frame_by_frame_ex)

        btn1 = findViewById(R.id.btnstart)
        imageView = findViewById(R.id.imageView)
        animationDrawable = imageView.background as AnimationDrawable

        btn1.setOnClickListener {

            if(animationDrawable.isRunning())
            {
                animationDrawable.stop()
            }
            else
            {
                animationDrawable.start()
            }

        }



    }
}