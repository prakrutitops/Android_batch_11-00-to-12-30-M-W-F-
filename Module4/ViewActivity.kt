package com.example.sqlitedb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import android.widget.SimpleAdapter
import com.example.sqlitedb.databinding.ActivityMainBinding
import com.example.sqlitedb.databinding.ActivityViewBinding

class ViewActivity : AppCompatActivity()
{
    private lateinit var binding: ActivityViewBinding
    lateinit var dbHelper: DbHelper
    var list: List<Model> = ArrayList()
    var arrayList = ArrayList<HashMap<String, String?>>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityViewBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        dbHelper = DbHelper(applicationContext)

        list = dbHelper.viewdata()


        for(i in list)
        {
            var hm = HashMap<String,String?>()
            hm["NAME"]=i.name
            hm["PASS"]=i.pass
            arrayList.add(hm)
        }

        var from = arrayOf("NAME","PASS")
        var to = intArrayOf(R.id.txt1,R.id.txt2)

        var adapter = SimpleAdapter(applicationContext,arrayList,R.layout.design,from,to)
        binding.list.adapter=adapter
    }
}