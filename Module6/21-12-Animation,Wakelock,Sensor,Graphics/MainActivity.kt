package com.quint.sensorex

import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Bundle
import android.view.Window
import android.view.WindowManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity(),SensorEventListener
{
    lateinit var txt1:TextView
    lateinit var sensorManager: SensorManager
    var color=false
    var lastupdate=123456565

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        requestWindowFeature(Window.FEATURE_NO_TITLE)

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN)

        setContentView(R.layout.activity_main)
        txt1 = findViewById(R.id.txt1)
        txt1.setBackgroundColor(Color.GREEN)

        sensorManager = getSystemService(SENSOR_SERVICE) as SensorManager
        lastupdate = System.currentTimeMillis().toInt()

    }

    override fun onSensorChanged(p0: SensorEvent?)
    {
            if(p0!!.sensor.type==Sensor.TYPE_ACCELEROMETER)
            {
                getaccelarometer(p0)
            }
    }

    private fun getaccelarometer(p0: SensorEvent)
    {

        val values = p0.values

        val x = values[0]
        val y = values[1]
        val z = values[2]

        var accelationSquareRoot = (x * x + y * y + z * z) / (SensorManager.GRAVITY_EARTH * SensorManager.GRAVITY_EARTH)
        var actualTime = p0.timestamp
        if(accelationSquareRoot >= 2)
        {
            if(actualTime - lastupdate < 200)
            {
                return
            }
            lastupdate = actualTime.toInt()

            Toast.makeText(applicationContext,"Device Was Shuffled",Toast.LENGTH_LONG).show()

            if(color)
            {
                txt1.setBackgroundColor(Color.GREEN)
            }
            else
            {
                txt1.setBackgroundColor(Color.RED)
            }

            color = !color
        }


    }

    override fun onAccuracyChanged(p0: Sensor?, p1: Int)
    {

    }

    override fun onResume() {
        super.onResume()
        sensorManager.registerListener(this,
            sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER),
            SensorManager.SENSOR_DELAY_NORMAL)
    }

    override fun onPause() {
        super.onPause()
        sensorManager.unregisterListener(this)
    }
}