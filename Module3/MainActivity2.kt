package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.viewpager.widget.ViewPager
import com.google.android.material.tabs.TabLayout

class MainActivity2 : AppCompatActivity()
{
    lateinit var toolbar: Toolbar
    lateinit var viewPager: ViewPager
    lateinit var tabLayout: TabLayout

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        toolbar=findViewById(R.id.tool)
        setSupportActionBar(toolbar)

        viewPager = findViewById(R.id.viewpager)
        setupview()

        tabLayout = findViewById(R.id.tab)
        tabLayout.setupWithViewPager(viewPager)

    }

    private fun setupview()
    {
            var adapter =MyAdapter(supportFragmentManager)
            adapter.mydata("CHAT",ChatFragment())
            adapter.mydata("STATUS",StatusFragment())
            adapter.mydata("CALL",CallFragment())
            viewPager.adapter=adapter
    }
}