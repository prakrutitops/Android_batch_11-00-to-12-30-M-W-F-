package com.example.listandsearchex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.SearchView
import com.example.listandsearchex.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{

    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<String>


    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add("Android")
        list.add("Java")
        list.add("Php")
        list.add("Ios")


        var adapter1 = ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        binding.list.adapter=adapter1

        binding.search.setOnQueryTextListener(object:SearchView.OnQueryTextListener{

            override fun onQueryTextSubmit(p0: String?): Boolean {

                /*if(list.contains(p0))
                {
                    adapter1.filter.filter(p0)
                }*/

                return false

            }

            override fun onQueryTextChange(p0: String?): Boolean
            {

                adapter1.filter.filter(p0)

                return false
            }
        })
    }
}