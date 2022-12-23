package com.quint.audiovideoex

import android.annotation.SuppressLint
import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity


class MainActivity3 : AppCompatActivity(), MediaPlayer.OnPreparedListener {
    var url="https://vyasprakruti.000webhostapp.com/tennessee_whiskey.mp3"
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageButton: ImageButton
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        imageButton=findViewById(R.id.imageButton)
        mediaPlayer=MediaPlayer()
        imageButton.setOnClickListener {



                mediaPlayer=MediaPlayer()

                mediaPlayer.setDataSource(url)
                mediaPlayer.prepareAsync()
                mediaPlayer.setOnPreparedListener(this)


            }




        }
    override fun onPrepared(p0: MediaPlayer?)
    {
        mediaPlayer.start()
    }

    }



