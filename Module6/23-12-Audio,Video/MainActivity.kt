package com.quint.audiovideoex

import android.annotation.SuppressLint
import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var mediaPlayer: MediaPlayer

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        //mediaPlayer = MediaPlayer.create(applicationContext,R.raw.tennessee_whiskey)
        btn1.setOnClickListener {

               startActivity(Intent(this,MainActivity2::class.java))

        }


        btn2.setOnClickListener {

            startActivity(Intent(this,MainActivity3::class.java))

        }


        btn3.setOnClickListener {

            startActivity(Intent(this,MainActivity4::class.java))

        }

    }
}