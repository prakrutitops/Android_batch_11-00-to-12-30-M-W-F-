package com.example.volleycrudapp

import android.content.ContextParams
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleycrudapp.databinding.ActivityMainBinding
import org.json.JSONException

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btninsert.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()
            var pdes = binding.edt3.text.toString()


            var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileproductinsert.php",
                Response.Listener {

                    try {
                        Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG).show()
                        var i =Intent(this,MainActivity2::class.java)
                        startActivity(i)
                    } catch (e: JSONException) {
                        Log.d("Error", e.message.toString())
                    }
            },
                Response.ErrorListener {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()


                })
            {
                override fun getParams(): MutableMap<String, String>?
                {
                    var map = HashMap<String, String>()
                    map["p_name"] = pname
                    map["p_price"] = pprice
                    map["p_des"] = pdes

                    return map
                }

            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)


            /* var stringRequest = StringRequest(Request.Method.POST,
                "https://vyasprakruti.000webhostapp.com/30Nov/mobileproductinsert.php",
                { response ->

                    try {
                        Toast.makeText(applicationContext, "Data Inserted", Toast.LENGTH_LONG)
                            .show()
                    } catch (e: JSONException) {
                        Log.d("Error", e.message.toString())
                    }

                },
                Response.ErrorListener
                {
                    Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()

                })
            {
                fun getParams(): HashMap<String, String> {
                    var map = HashMap<String, String>()
                    map["p_name"] = pname
                    map["p_price "] = pprice
                    map["p_des "] = pdes

                    return map
                }

            }

            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)

        }*/
        }
    }
}