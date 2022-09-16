package com.example.listandsearchex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import com.example.listandsearchex.databinding.ActivityMain2Binding


class MainActivity2 : AppCompatActivity(), AdapterView.OnItemSelectedListener {
    lateinit var binding: ActivityMain2Binding
    var city = arrayOf("Rajkot","baroda","surat","ahmedabad","xyz")

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.a1.threshold=2

        var adapter1 = ArrayAdapter(this,android.R.layout.select_dialog_item,city)
        binding.a1.setAdapter(adapter1)

        var adapter2 =ArrayAdapter(this,android.R.layout.simple_spinner_dropdown_item,city)
        binding.s1.adapter=adapter2

        binding.s1.setOnItemSelectedListener(this)
    }

    override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {


        //Toast.makeText(applicationContext,"Selected "+city[p2],Toast.LENGTH_LONG).show()
        Toast.makeText(applicationContext,"Selected "+p2,Toast.LENGTH_LONG).show()
    }

    override fun onNothingSelected(p0: AdapterView<*>?) {

    }
}