package com.example.firstapp

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    //declaration
    lateinit var image1:ImageView
    lateinit var image2:ImageView
    lateinit var text1:TextView
    lateinit var text2:TextView
    lateinit var img4:ImageView

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        image1=findViewById(R.id.img1)
        image2=findViewById(R.id.img2)
        text1=findViewById(R.id.txt2)
        text2=findViewById(R.id.txt3)
        img4=findViewById(R.id.img4)

        text1.setOnClickListener {

            Toast.makeText(applicationContext,"Android Technology",Toast.LENGTH_LONG).show()

            //Explicit
            var i =Intent(this,MainActivity2::class.java)
            startActivity(i)


        }

       image1.setOnClickListener {

                var url="https://www.tutorialspoint.com/android/index.htm"
                var i =Intent(Intent.ACTION_VIEW)
                i.setData(Uri.parse(url))
                startActivity(i)

       }

        text2.setOnClickListener {
            Toast.makeText(applicationContext,"Java Technology",Toast.LENGTH_LONG).show()
        }


        img4.setOnClickListener {

            var url="9999999999"
            var i =Intent(Intent.ACTION_CALL)
            i.setData(Uri.parse("tel:"+url))
            startActivity(i)

        }




    }
}