package com.example.customlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.customlist.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        list.add(Model(R.drawable.android,"Android","It's a Mobile App Development Platform"))
        list.add(Model(R.drawable.java1,"Java","It's a web development Secure platform"))
        list.add(Model(R.drawable.php,"Php","It's web based Platform"))



        var adapter =MyAdapter(this,list)
        binding.list.adapter=adapter
    }
}