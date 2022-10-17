package com.example.sqlitedb

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.sqlitedb.databinding.ActivityMainBinding
import com.example.sqlitedb.databinding.ActivityUpdateBinding

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding
    lateinit var dbHelper: DbHelper
    var id =0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)
        var i1=intent


        id = i1.getIntExtra("id1",101)
        binding.uedtname.setText(i1.getStringExtra("name1"))
        binding.uedtpass.setText(i1.getStringExtra("pass1"))

        Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()



        binding.btnupdate.setOnClickListener {

                var uname =binding.uedtname.text.toString()
                var upass = binding.uedtpass.text.toString()

                var m =Model()
                m.id =id
                m.name=uname
                m.pass=upass

                dbHelper.updatedata(m)

                startActivity(Intent(this,ViewActivity::class.java))


        }

    }
}