package com.example.registerloginex

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

class LoginActivity : AppCompatActivity()
{
    lateinit var edt1: EditText
    lateinit var edt2: EditText
    lateinit var edt3: EditText
    lateinit var btn1: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edt1 = findViewById(R.id.edt1)
        edt2 = findViewById(R.id.edt2)

        btn1 = findViewById(R.id.btn1)

        btn1.setOnClickListener {

            var uname = edt1.text.toString()
            var pass = edt2.text.toString()

            var stringRequest: StringRequest = object : StringRequest(Request.Method.POST,
                "https://vyasprakruti.000webhostapp.com/Morning_Batch_API/login.php",
                Response.Listener {
                    response->
                        if(response.trim().equals("0"))
                        {
                            Toast.makeText(applicationContext,"Fail", Toast.LENGTH_LONG).show()
                        }
                        else
                        {
                            Toast.makeText(applicationContext,"Login Succesful", Toast.LENGTH_LONG).show()

                        }


                },
                Response.ErrorListener {

                    Toast.makeText(applicationContext,"Error", Toast.LENGTH_LONG).show()

                })


            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String,String>()
                    map["u1"]=uname
                    map["p1"]=pass

                    return map
                }


            }

            var queue: RequestQueue = Volley.newRequestQueue(applicationContext)
            queue.add(stringRequest)




        }

    }
}