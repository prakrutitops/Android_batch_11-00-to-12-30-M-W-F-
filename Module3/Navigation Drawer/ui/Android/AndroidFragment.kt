package com.example.navigationexample.ui.Android

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import com.example.navigationexample.Model
import com.example.navigationexample.MyAdapter

import com.example.navigationexample.R


class AndroidFragment : Fragment() {

    lateinit var listView: ListView
    lateinit var list: MutableList<Model>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View? {
        // Inflate the layout for this fragment
        var view = inflater.inflate(R.layout.fragment_android, container, false)

            listView = view.findViewById(R.id.list)
            list = ArrayList()

            list.add(Model("Intent"))
            list.add(Model("Activity Lifecycle"))
            list.add(Model("Fragment"))
            list.add(Model("UI Controls"))
            list.add(Model("Adapter"))

            var myAdapter =MyAdapter(requireActivity(),list)
            listView.adapter=myAdapter

        return view
    }


}