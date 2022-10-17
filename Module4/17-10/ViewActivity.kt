package com.example.sqlitedb

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.SimpleAdapter
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
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
        registerForContextMenu(binding.list)

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

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        var m1 :MenuItem = menu!!.add(0,1,0,"Update")
        var m2:MenuItem = menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {
        var acm :AdapterContextMenuInfo = item.menuInfo as AdapterContextMenuInfo
        var id2 =acm.position
        val user = list!![id2]


        when(item.itemId)
        {

            1->
            {
                    var i =Intent(this,UpdateActivity::class.java)
                    i.putExtra("id1",user.id)
                    i.putExtra("name1",user.name)
                    i.putExtra("pass1",user.pass)
                    startActivity(i)


            }
            2->
            {
                var alert =AlertDialog.Builder(this)
                alert.setTitle("Are you sure you want to delete?")
                alert.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                   // Toast.makeText(applicationContext,""+id,Toast.LENGTH_LONG).show()
                    dbHelper.deletedata(user.id)
                    startActivity(Intent(this,ViewActivity::class.java))



                })
                alert.setNegativeButton("NO",{
                        dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()

                })

                alert.show()

            }


        }



        return super.onContextItemSelected(item)
    }
}