package com.tops.data1

import android.content.Intent
import android.content.IntentFilter
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.animation.AnimationUtils
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()
{

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)

        var receiver = MyReceiver()
        val filter = IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION)
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED)
        registerReceiver(receiver, filter)
        animatedata()

        btn1.setOnClickListener {

          /*  var i = Intent(applicationContext,MyService::class.java)
            startService(i)*/


        }
        btn2.setOnClickListener {
            var i = Intent(applicationContext,MyService::class.java)
            stopService(i)
        }
        btn3.setOnClickListener {


        }

    }

    private fun animatedata()
    {

        var anim = AnimationUtils.loadAnimation(applicationContext,R.anim.blink)
        btn1.startAnimation(anim)
    }
}