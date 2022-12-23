package com.quint.audiovideoex

import android.Manifest
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity4 : AppCompatActivity() {
    lateinit var mediaPlayer: MediaPlayer
    lateinit var imageButton: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main4)

        imageButton = findViewById(R.id.imageButton);
        mediaPlayer = MediaPlayer()
        checkPermission1()
        imageButton.setOnClickListener {

            var file: File = Environment.getExternalStorageDirectory();
            file = File(file, "Path")
            imageButton.setImageResource(android.R.drawable.ic_media_pause);
            if (file.exists()) {
                var uri: Uri = Uri.fromFile(file)
                mediaPlayer = MediaPlayer.create(this, uri);
                mediaPlayer.start()



            }
        }


    }

    private fun checkPermission1() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE),
                    123)
            }
        }
    }
}
