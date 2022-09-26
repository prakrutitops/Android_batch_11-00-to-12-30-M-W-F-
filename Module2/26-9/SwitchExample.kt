package com.example.myapplication

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.CompoundButton
import android.widget.Switch
import android.widget.Toast

class SwitchExample : AppCompatActivity(), CompoundButton.OnCheckedChangeListener {
    lateinit var s1:Switch
    lateinit var mediaPlayer: MediaPlayer

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_switch_example)

        s1 = findViewById(R.id.s1)
        mediaPlayer = MediaPlayer.create(applicationContext,R.raw.gods_country)

        s1.setOnCheckedChangeListener(this)
    }

    override fun onCheckedChanged(p0: CompoundButton?, p1: Boolean)
    {
       if(s1.isChecked)
       {
            //Toast.makeText(applicationContext,"ON",Toast.LENGTH_LONG).show()
            mediaPlayer.start()
       }
       else
       {
           Toast.makeText(applicationContext,"OFF",Toast.LENGTH_LONG).show()
           mediaPlayer.stop()
       }
    }
}