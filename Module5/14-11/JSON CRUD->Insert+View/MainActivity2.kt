package com.example.volleycrudapp


import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleycrudapp.databinding.ActivityMain2Binding
import com.example.volleycrudapp.databinding.ActivityMainBinding
import org.json.JSONArray
import org.json.JSONException

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()

        var stringRequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileview.php",
            {response->

                try
                {

                        var jsonArray = JSONArray(response)
                        for(i in 0 until  jsonArray.length())
                        {
                            var jsonObject = jsonArray.getJSONObject(i)

                            var m =Model()
                            m.id=jsonObject.getInt("id")
                            m.pname=jsonObject.getString("p_name")
                            m.pprice=jsonObject.getString("p_price")
                            m.pdes=jsonObject.getString("p_des")
                            list.add(m)

                        }


                }
                catch (e:JSONException)
                {
                    Log.d("Error",e.message.toString())
                }

                var myAdapter = MyAdapter(applicationContext,list)
                binding.list.adapter=myAdapter

        })
        {

        }
        var queue:RequestQueue=Volley.newRequestQueue(this)
        queue.add(stringRequest)


    }
}