package com.example.jsonparsingex

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.jsonparsingex.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityMainBinding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        list = ArrayList()

        var layoutManager:RecyclerView.LayoutManager = LinearLayoutManager(this)
        binding.recycler.layoutManager=layoutManager

        var stringRequest =StringRequest(Request.Method.POST,Other.url,{
                response->
                try
                {
                    var jsonObject = JSONObject(response)
                    var jsonArray = jsonObject.getJSONArray("heroes")
                    for(i in 0 until  jsonArray.length())
                    {
                        var jsonObject2=jsonArray.getJSONObject(i)

                        var name = jsonObject2.get("name").toString()
                        var image = jsonObject2.get("imageurl").toString()

                        var m =Model()
                        m.name=name
                        m.image=image

                        list.add(m)


                    }
                    var myAdapter = MyAdapter(applicationContext,list)
                    binding.recycler.adapter=myAdapter
                }
                catch (e:JSONException)
                {
                    Toast.makeText(applicationContext,""+e.message,Toast.LENGTH_LONG).show()
                }
        })
        {
            Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }

        var queue:RequestQueue = Volley.newRequestQueue(this)
        queue.add(stringRequest)
    }

}