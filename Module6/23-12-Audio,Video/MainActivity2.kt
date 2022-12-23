package com.quint.audiovideoex

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity()
{
    lateinit var mediaPlayer: MediaPlayer
    lateinit var StartServiceButton: Button
    lateinit var StopServiceButton:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        mediaPlayer = MediaPlayer.create(this, R.raw.tennessee_whiskey)

        StartServiceButton = findViewById(R.id.start_button_id);
        StopServiceButton = findViewById(R.id.stop_button_id)

        StartServiceButton.setOnClickListener {

            mediaPlayer.start()
        }
        StopServiceButton.setOnClickListener {

            mediaPlayer.stop()
        }

    }
}