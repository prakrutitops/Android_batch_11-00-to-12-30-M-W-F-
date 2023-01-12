package com.example.firstapp.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.Adapter.CategoryAdapter
import com.example.firstapp.Adapter.DashboardAdapter
import com.example.firstapp.ApiClient
import com.example.firstapp.Apiinterface
import com.example.firstapp.Model.Category_Model
import com.example.firstapp.Model.Dashboard_Model
import com.example.firstapp.R
import com.example.firstapp.databinding.ActivityCategoryBinding
import com.example.firstapp.databinding.ActivityDashboardBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CategoryActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityCategoryBinding
    lateinit var apiinterface: Apiinterface
    var categorydata:Call<List<Category_Model?>?>? = null
    lateinit var list:MutableList<Category_Model>
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityCategoryBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        var i = intent
        var pos = i.getIntExtra("c_pos",111)
        Toast.makeText(applicationContext,""+pos,Toast.LENGTH_LONG).show()
        list = ArrayList()

        apiinterface = ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recyclerCategory.layoutManager=layoutManager

     /*   for(i in 0..3)
        {
            if(pos == i)
            {

            }
        }
        */

        if(pos==0)
        {
             categorydata = apiinterface.diwalidata
        }
        if(pos==1)
        {
             categorydata =   apiinterface.holidata
        }

        categorydata!!.enqueue(object: Callback<List<Category_Model?>?> {
            override fun onResponse(call: Call<List<Category_Model?>?>, response: Response<List<Category_Model?>?>)
            {
                list = response.body() as MutableList<Category_Model>

                var adapter = CategoryAdapter(applicationContext,list)
                binding.recyclerCategory.adapter = adapter
            }

            override fun onFailure(call: Call<List<Category_Model?>?>, t: Throwable)
            {
                Toast.makeText(applicationContext,"Error in Data Fetching",Toast.LENGTH_LONG).show()
            }
        })




    }
}