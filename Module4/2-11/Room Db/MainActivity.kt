package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.Activity.AdduserActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity()
{
    lateinit var fl1:FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fl1 = findViewById(R.id.fab)
        fl1.setOnClickListener {

                var i =Intent(this, AdduserActivity::class.java)
                startActivity(i)

        }
    }
}