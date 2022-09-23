package com.example.fragmentex

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView


class FirstFragment : Fragment() {

    lateinit var txt1:TextView
    lateinit var txt2:TextView

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?, ): View?
    {
        // Inflate the layout for this fragment

         var view = inflater.inflate(R.layout.fragment_first, container, false)

            txt1 = view.findViewById(R.id.txt1)
            txt2 = view.findViewById(R.id.txt2)

        txt1.setOnClickListener {

              var i =Intent(activity,MainActivity::class.java)
              startActivity(i)

        }

        txt2.setOnClickListener {

            var s =SecondFragment()
            var fm =fragmentManager
            var ft = fm!!.beginTransaction()
            ft.replace(R.id.f1,s).commit()

        }

        return view

    }


}