package com.example.customex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.customex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btn1.setOnClickListener {

            //Custom Toast

            var t =Toast(this)
            var l =LayoutInflater.from(this)
            var view1= l.inflate(R.layout.custom_toast,null)
            t.view=view1
            t.setGravity(Gravity.CENTER,0,0)
            t.duration=Toast.LENGTH_LONG
            t.show()


        }
        binding.btn2.setOnClickListener {

            var alert=AlertDialog.Builder(this)
            var l =LayoutInflater.from(this)
            var view1= l.inflate(R.layout.custom_dialog,null)
            alert.setView(view1)
            alert.show()

        }
    }


}