package com.example.newexample

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var btn:Button

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView=findViewById(R.id.txt1)
        btn=findViewById(R.id.btn1)
        registerForContextMenu(textView)

        btn.setOnClickListener {

            var menu1=PopupMenu(this,btn)
            menuInflater.inflate(R.menu.popup,menu1.menu)
            menu1.setOnMenuItemClickListener(object :PopupMenu.OnMenuItemClickListener{
                override fun onMenuItemClick(p0: MenuItem?): Boolean
                {

                    when(p0!!.itemId)
                    {
                        R.id.detail->
                        {
                            Toast.makeText(applicationContext,"Popup Called",Toast.LENGTH_LONG).show()
                        }
                    }

                    return false
                }
            })
            menu1.show()

        }
    }

    //Menu View
    override fun onCreateOptionsMenu(menu: Menu): Boolean
    {
        menuInflater.inflate(R.menu.option,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {

        when(item.itemId)
        {
            R.id.i1->
            {
                var num="9999999999"
                var i =Intent(Intent.ACTION_CALL)
                i.setData(Uri.parse("tel:"+num))
                startActivity(i)
            }
            R.id.i2->
            {
              Toast.makeText(applicationContext,"About Us",Toast.LENGTH_LONG).show()
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        menuInflater.inflate(R.menu.context,menu)

        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        when(item.itemId)
        {
            R.id.pos->
            {
                Toast.makeText(applicationContext,"Position called",Toast.LENGTH_LONG).show()
            }
        }
        return super.onContextItemSelected(item)
    }


}