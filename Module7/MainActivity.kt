package com.example.texttospeechex

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import android.speech.tts.TextToSpeech
import android.speech.tts.TextToSpeech.QUEUE_ADD
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import org.intellij.lang.annotations.Language
import java.util.Locale.LanguageRange
import java.util.Locale.US

class MainActivity : AppCompatActivity(), TextToSpeech.OnInitListener {
    lateinit var edt1:EditText
    lateinit var btn1:Button
    lateinit var tts:TextToSpeech
    lateinit var btn2:Button
    lateinit var img:ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        tts = TextToSpeech(applicationContext,this)
        img = findViewById(R.id.img)

        btn1.setOnClickListener {

                var data = edt1.text.toString()
                tts.speak(data,QUEUE_ADD,null)



        }

        btn2.setOnClickListener {

            var i =Intent(ACTION_IMAGE_CAPTURE)
            startActivityForResult(i,1)

        }


    }

    override fun onInit(p0: Int)
    {
        tts.setLanguage(US)
        tts.setPitch(0.8F)
        tts.setSpeechRate(0.5F)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?)
    {
        super.onActivityResult(requestCode, resultCode, data)


        var bm :Bitmap = data!!.extras!!.get("data") as Bitmap
        img.setImageBitmap(bm)
    }
}