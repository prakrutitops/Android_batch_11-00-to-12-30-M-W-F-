package com.example.firstapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityCategoryBinding
import com.example.firstapp.databinding.ActivityFullScreenBinding
import com.squareup.picasso.Picasso

class FullScreenActivity : AppCompatActivity() {

    private lateinit var binding: ActivityFullScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFullScreenBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        var i = intent
        var url = i.getStringExtra("f_pos")


        Picasso.get().load(url).into(binding.photo)




    }
}