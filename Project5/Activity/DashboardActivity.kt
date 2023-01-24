package com.example.adminlogin.Activity

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adminlogin.Adapter.DashboardAdapter
import com.example.adminlogin.ApiClient
import com.example.adminlogin.Apiinterface
import com.example.adminlogin.R
import com.example.adminlogin.databinding.ActivityDashboardBinding
import com.example.firstapp.Model.Dashboard_Model
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DashboardActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityDashboardBinding
    lateinit var sharedPreferences: SharedPreferences
    lateinit var list:MutableList<Dashboard_Model>
    lateinit var apiinterface: Apiinterface


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedPreferences=getSharedPreferences("user_session", Context.MODE_PRIVATE)
        Toast.makeText(applicationContext,"Welcome "+sharedPreferences.getString("mob",null),Toast.LENGTH_LONG).show()

        list = ArrayList()
        apiinterface= ApiClient.getapiclient()!!.create(Apiinterface::class.java)

        var layoutManager: RecyclerView.LayoutManager = GridLayoutManager(this,2)
        binding.recyclerDashboard.layoutManager=layoutManager

        val adRequest = AdRequest.Builder().build()
        binding.adView.loadAd(adRequest)


        var dashboardata: Call<List<Dashboard_Model?>?>? = apiinterface.dashboard_view
        dashboardata!!.enqueue(object:Callback<List<Dashboard_Model?>?>{
            override fun onResponse(call: Call<List<Dashboard_Model?>?>, response: Response<List<Dashboard_Model?>?>)
            {
                list = response.body() as MutableList<Dashboard_Model>

                var dashboardadapter = DashboardAdapter(applicationContext,list)
                binding.recyclerDashboard.adapter=dashboardadapter
            }

            override fun onFailure(call: Call<List<Dashboard_Model?>?>, t: Throwable)
            {
                Toast.makeText(applicationContext,"Error in Data Fetching",Toast.LENGTH_LONG).show()
            }
        })



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        when(item.itemId)
        {
            R.id.logout->
            {
                sharedPreferences.edit().clear().commit()
                //finish()
                startActivity(Intent(this,MainActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }
}