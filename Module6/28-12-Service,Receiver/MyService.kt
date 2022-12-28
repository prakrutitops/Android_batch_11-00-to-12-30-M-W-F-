package com.tops.data1

import android.Manifest.permission.ACCESS_FINE_LOCATION
import android.app.Activity
import android.app.Service
import android.content.Intent
import android.content.pm.PackageManager
import android.media.MediaPlayer
import android.os.Build
import android.os.IBinder
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.ActivityCompat

class MyService : Service()
{
    lateinit var activity: MainActivity
     lateinit var player: MediaPlayer
   // var mContext: Context = applicationContext
    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate()
    {
        super.onCreate()
        //Toast.makeText(applicationContext,"Created",Toast.LENGTH_LONG).show()

        activity = MainActivity()
        player = MediaPlayer.create(this, R.raw.tennessee_whiskey)
       /* if(checkSelfPermission(ACCESS_FINE_LOCATION)!= PackageManager.PERMISSION_GRANTED)
        {

                    ActivityCompat.requestPermissions((context as Activity), arrayOf(ACCESS_FINE_LOCATION),101)

        }*/

    }

    override fun onStart(intent: Intent?, startId: Int)
    {
        super.onStart(intent, startId)
        Toast.makeText(applicationContext,"Started",Toast.LENGTH_LONG).show()
        player.start()
    }
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int
    {
        Toast.makeText(applicationContext,"Start Command",Toast.LENGTH_LONG).show()

        return super.onStartCommand(intent, flags, startId)

    }
    override fun onBind(intent: Intent): IBinder
    {

        TODO("Return the communication channel to the service.")
    }

    override fun onDestroy()
    {
        Toast.makeText(applicationContext,"Destroy",Toast.LENGTH_LONG).show()

        super.onDestroy()
        player.stop()
    }

}