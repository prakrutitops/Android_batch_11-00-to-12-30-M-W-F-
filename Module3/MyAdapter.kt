package com.example.myapplication

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter

class MyAdapter(fm:FragmentManager) : FragmentStatePagerAdapter(fm)
{
    var listFragment:MutableList<Fragment> = ArrayList()
    var listtitle:MutableList<String> = ArrayList()



    override fun getCount(): Int
    {
        return listtitle.size
    }

    override fun getItem(position: Int): Fragment
    {
        return listFragment.get(position)
    }

    override fun getPageTitle(position: Int): CharSequence?
    {

        return listtitle.get(position)
    }

    fun mydata(title:String,fragment: Fragment)
    {
        listtitle.add(title)
        listFragment.add(fragment)
    }

}