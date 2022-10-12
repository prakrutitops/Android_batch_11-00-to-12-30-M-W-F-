package com.example.navigationexample.ui.Java

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.navigationexample.Model
import com.example.navigationexample.MyAdapter

import com.example.navigationexample.R


class JavaFragment : Fragment() {

    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    @SuppressLint("MissingInflatedId")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_java, container, false)

        listView = view.findViewById(R.id.list)
        list = ArrayList()

        list.add(Model("Keywords"))
        list.add(Model("OOP"))
        list.add(Model("exception handling"))

        var myAdapter =MyAdapter(requireActivity(),list)
        listView.adapter=myAdapter

        return view
    }


}