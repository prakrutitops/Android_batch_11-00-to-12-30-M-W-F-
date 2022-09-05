package com.example.mysecondapp

import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AlertDialog

class MainActivity2 : AppCompatActivity()
{
    lateinit var btn1:Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        btn1=findViewById(R.id.btn1)

        btn1.setOnClickListener {

            finishAffinity()

        }
    }

    override fun onBackPressed() {

        var alert = AlertDialog.Builder(this)
        alert.setTitle("Are you sure you want to exit?")
        alert.setPositiveButton("YES",{ dialogInterface: DialogInterface, i: Int ->

            finishAffinity()

        })
        alert.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

            dialogInterface.cancel()
        })
        alert.show()

    }
}