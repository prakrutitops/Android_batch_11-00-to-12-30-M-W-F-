package com.example.extra1

import android.Manifest.permission.CALL_PHONE
import android.Manifest.permission.CAMERA
import android.content.pm.PackageManager.PERMISSION_GRANTED
import android.hardware.Camera
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.RequiresApi
import com.example.extra1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding


    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)



        binding.btn1.setOnClickListener {
               allowpermission()


        }
        binding.btn2.setOnClickListener {
          allowpermission()

        }



    }

    @RequiresApi(Build.VERSION_CODES.M)
    fun allowpermission()
    {
        if(checkSelfPermission(CALL_PHONE)!=PERMISSION_GRANTED && checkSelfPermission(CAMERA)!= PERMISSION_GRANTED)
        {
            requestPermissions(arrayOf(CALL_PHONE, CAMERA),101)
        }
    }
}