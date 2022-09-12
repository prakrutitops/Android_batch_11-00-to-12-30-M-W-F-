package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RadioButton
import android.widget.Toast

class RadioButtonActivity : AppCompatActivity()
{
    lateinit var rb1:RadioButton
    lateinit var rb2:RadioButton

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_radio_button)

        rb1=findViewById(R.id.rb1)
        rb2=findViewById(R.id.rb2)

        rb1.setOnCheckedChangeListener { compoundButton, b ->

                if(rb1.isChecked)
                {
                    Toast.makeText(applicationContext,"Male",Toast.LENGTH_LONG).show()
                }

        }
        rb2.setOnCheckedChangeListener { compoundButton, b ->


            if(rb2.isChecked)
            {
                Toast.makeText(applicationContext,"Female",Toast.LENGTH_LONG).show()
            }
        }
    }
}