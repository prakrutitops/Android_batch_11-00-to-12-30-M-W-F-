package com.example.firebasecrudapp


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.FirebaseDatabase





class MainActivity2 : AppCompatActivity()
{
    lateinit var recyclerView: RecyclerView
    lateinit var myAdapter:MyAdapter
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        recyclerView = findViewById(R.id.recycler)

        val rl: RecyclerView.LayoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = rl

        val options = FirebaseRecyclerOptions.Builder<Model>()
            .setQuery(FirebaseDatabase.getInstance().reference.child("android1"), Model::class.java)
            .build()

         myAdapter =MyAdapter(options)
        recyclerView.adapter=myAdapter




    }
    override fun onStart() {
        super.onStart()
        myAdapter.startListening()
    }

    override fun onStop() {
        super.onStop()
        myAdapter.stopListening()
    }

    override fun onRestart() {
        super.onRestart()
        myAdapter.startListening()
    }

    override fun onResume() {
        super.onResume()
        myAdapter.startListening()
    }

    override fun onPause() {
        super.onPause()
        myAdapter.stopListening()
    }


}