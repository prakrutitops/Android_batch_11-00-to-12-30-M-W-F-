package com.example.volleycrudapp

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
import com.example.volleycrudapp.databinding.ActivityUpdateBinding
import org.json.JSONException

class UpdateActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityUpdateBinding

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i =intent
        var id =i.getIntExtra("id",101)
        Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()
        binding.edt1.setText(i.getStringExtra("name"))
        binding.edt2.setText(i.getStringExtra("price"))
        binding.edt3.setText(i.getStringExtra("des"))

        binding.btnupdate.setOnClickListener {

            var pname = binding.edt1.text.toString()
            var pprice = binding.edt2.text.toString()
            var pdes = binding.edt3.text.toString()

            var stringRequest: StringRequest = object: StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileupdate.php",
                Response.Listener {

                    try {
                        Toast.makeText(applicationContext, "Data Updated", Toast.LENGTH_LONG).show()
                        var i = Intent(this,MainActivity2::class.java)
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
                    map["id"]=id.toString()
                    map["p_name"] = pname
                    map["p_price"] = pprice
                    map["p_des"] = pdes

                    return map
                }

            }
            var queue: RequestQueue = Volley.newRequestQueue(this)
            queue.add(stringRequest)



        }

    }
}