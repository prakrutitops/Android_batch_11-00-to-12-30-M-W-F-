package com.tops.data1

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.widget.Toast

class MyReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent)
    {
       if(intent.action!!.equals(Intent.ACTION_AIRPLANE_MODE_CHANGED))
       {
           Toast.makeText(context,"Flight Mode Changed",Toast.LENGTH_LONG).show()
       }
    }
}