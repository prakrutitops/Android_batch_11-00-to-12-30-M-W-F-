package com.example.sqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedb.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var dbHelper: DbHelper

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        binding.btninsert.setOnClickListener {

            var name1 =binding.edtname.text.toString()
            var pass1 = binding.edtpass.text.toString()

            var m =Model()
            m.name=name1
            m.pass=pass1

           var id = dbHelper.insertdata(m)

            if(id>0)
            {
                Toast.makeText(applicationContext,"Record Inserted "+id,Toast.LENGTH_LONG).show()
                startActivity(Intent(this,ViewActivity::class.java))
            }
            else
            {
                Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

            }

        }
        binding.btnview.setOnClickListener {

            startActivity(Intent(this,ViewActivity::class.java))

        }

    }
}