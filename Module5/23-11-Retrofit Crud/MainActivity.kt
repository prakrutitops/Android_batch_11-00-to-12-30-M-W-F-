package com.example.retrofitex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var btn1:Button
    lateinit var apiinterface: Apiinterface

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        btn1 = findViewById(R.id.btninsert)

        btn1.setOnClickListener {

                var name = edt1.text.toString()
                var price = edt2.text.toString()

          var data = ApiClient.getapiclient().create(Apiinterface::class.java)
          var call:Call<Void> = data.insertdata(name,price)
          call.enqueue(object :Callback<Void>
          {
              override fun onResponse(call: Call<Void>, response: Response<Void>) {

                  Toast.makeText(this@MainActivity, "Product added", Toast.LENGTH_SHORT).show()
                  val i = Intent(applicationContext, MainActivity2::class.java)
                  startActivity(i)

              }

              override fun onFailure(call: Call<Void>, t: Throwable) {

                  Toast.makeText(applicationContext, "Error", Toast.LENGTH_SHORT).show();

              }
          })


        }

    }
}