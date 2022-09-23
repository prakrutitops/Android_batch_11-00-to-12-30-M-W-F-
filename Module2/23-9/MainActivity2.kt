package com.example.fragmentex

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1 = findViewById(R.id.b1)
        btn2 = findViewById(R.id.b2)

        btn1.setOnClickListener {

            var i =Intent(this,MainActivity::class.java)
            startActivity(i)
        }
        btn2.setOnClickListener {

                var f =FirstFragment()
                var fm = supportFragmentManager
                var ft = fm.beginTransaction()
                ft.replace(R.id.f1,f).commit()


        }
    }
}