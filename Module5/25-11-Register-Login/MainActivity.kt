package com.example.registerloginex

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity()
{
    lateinit var edt1:EditText
    lateinit var edt2:EditText
    lateinit var edt3:EditText
    lateinit var btn1:Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)
        edt3 = findViewById(R.id.edt3)
        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var uname = edt1.text.toString()
            var pass = edt2.text.toString()
            var email = edt3.text.toString()

            var stringRequest: StringRequest = object : StringRequest(Request.Method.POST,
                "https://vyasprakruti.000webhostapp.com/Morning_Batch_API/insertdata.php",
                Response.Listener {


                        Toast.makeText(applicationContext,"Data Inserted",Toast.LENGTH_LONG).show()
                        startActivity(Intent(this,LoginActivity::class.java))

                },
                Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error",Toast.LENGTH_LONG).show()

                })


                {
                    override fun getParams(): MutableMap<String, String>?
                    {
                            var map = HashMap<String,String>()
                            map["username"]=uname
                            map["password"]=pass
                            map["email"]=email
                        return map
                    }


                }

            var queue:RequestQueue = Volley.newRequestQueue(this@MainActivity)
            queue.add(stringRequest)
        }


    }
}