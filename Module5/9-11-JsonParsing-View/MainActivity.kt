package com.example.jsonexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonexample.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list:MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/InventorymanaementSystem/productview.php",{response->
            try
            {
                    var jsonArray = JSONArray(response)
                    for(i in 0 until jsonArray.length())
                    {
                        var jsonObject = jsonArray.getJSONObject(i)


                        var name = jsonObject.getString("product_name")
                        var price = jsonObject.getString("product_price")
                        var des = jsonObject.getString("product_description")
                        var image =jsonObject.getString("product_image")


                        var m =Model()
                        m.product_name=name
                        m.product_price=price
                        m.product_description=des
                        m.product_image=image

                        list.add(m)


                    }

                    var adapter =MyAdapter(applicationContext,list)
                    binding.list.adapter=adapter


            }
            catch (e:JSONException)
            {
                Toast.makeText(applicationContext,""+e,Toast.LENGTH_LONG).show()
            }
        })
        {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }

        var queue:RequestQueue=Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }
}