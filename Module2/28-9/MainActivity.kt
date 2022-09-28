package com.example.toolaction

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import com.daimajia.slider.library.SliderLayout
import com.daimajia.slider.library.SliderTypes.TextSliderView
import com.daimajia.slider.library.SliderTypes.BaseSliderView





class MainActivity : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var slider:SliderLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        toolbar = findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        slider=findViewById(R.id.slider)

        toolbar.setLogo(R.mipmap.ic_launcher)
        toolbar.setSubtitle("Last Seen ")
        toolbar.setNavigationIcon(R.drawable.ic_baseline_arrow_back_24)
        toolbar.setNavigationOnClickListener {

            Toast.makeText(applicationContext,"Back Button Pressed",Toast.LENGTH_LONG).show()
        }

        var map = HashMap<String,Int>()
        map.put("A",R.drawable.a)
        map.put("B",R.drawable.flag1)
        map.put("C",R.drawable.a)
        map.put("D",R.drawable.flag1)

        for(name in map.keys)
        {
            var textslider =TextSliderView(this)
            textslider.description(name)
                      .image(map.get(name)!!)

            slider.addSlider(textslider)
        }


    }
}