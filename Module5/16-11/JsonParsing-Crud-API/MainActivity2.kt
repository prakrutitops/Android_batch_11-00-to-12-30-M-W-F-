package com.example.volleycrudapp


import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.ContextMenu
import android.view.MenuItem
import android.view.View
import android.widget.AdapterView.AdapterContextMenuInfo
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.volleycrudapp.databinding.ActivityMain2Binding
import org.json.JSONArray
import org.json.JSONException

class MainActivity2 : AppCompatActivity()
{
    private lateinit var binding: ActivityMain2Binding
    lateinit var list: MutableList<Model>

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        list = ArrayList()
        registerForContextMenu(binding.list)

        var stringRequest = StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobileview.php",
            {response->

                try
                {

                        var jsonArray = JSONArray(response)
                        for(i in 0 until  jsonArray.length())
                        {
                            var jsonObject = jsonArray.getJSONObject(i)

                            var m =Model()
                            m.id=jsonObject.getInt("id")
                            m.pname=jsonObject.getString("p_name")
                            m.pprice=jsonObject.getString("p_price")
                            m.pdes=jsonObject.getString("p_des")
                            list.add(m)

                        }


                }
                catch (e:JSONException)
                {
                    Log.d("Error",e.message.toString())
                }

                var myAdapter = MyAdapter(applicationContext,list)
                binding.list.adapter=myAdapter

            })
        {
                Toast.makeText(applicationContext,"No Internet",Toast.LENGTH_LONG).show()
        }
        var queue:RequestQueue=Volley.newRequestQueue(this)
        queue.add(stringRequest)

    }

    override fun onCreateContextMenu(menu: ContextMenu?, v: View?, menuInfo: ContextMenu.ContextMenuInfo?)
    {
        //menuInflater.inflate()
        var m1 = menu!!.add(0,1,0,"Update")
        var m2 =menu!!.add(0,2,0,"Delete")
        super.onCreateContextMenu(menu, v, menuInfo)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean
    {

        var acm:AdapterContextMenuInfo= item.menuInfo as AdapterContextMenuInfo
        var id =acm.position

        val m = list[id]


        when(item.itemId)
        {
            1->
            {

                var i =Intent(this,UpdateActivity::class.java)
                i.putExtra("id",m.id)
                i.putExtra("name",m.pname)
                i.putExtra("price",m.pprice)
                i.putExtra("des",m.pdes)
                startActivity(i)


            }
            2->
            {
                var alertDialog=AlertDialog.Builder(this)
                alertDialog.setTitle("Are you sure you want to delete?")
                alertDialog.setPositiveButton("YES",{
                        dialogInterface: DialogInterface, i: Int ->

                    var stringRequest:StringRequest = object:StringRequest(Request.Method.POST,"https://vyasprakruti.000webhostapp.com/30Nov/mobiledelete.php",
                        Response.Listener {

                            try {
                                Toast.makeText(applicationContext, "Data Deleted", Toast.LENGTH_LONG).show()
                                var i = Intent(this,MainActivity2::class.java)
                                startActivity(i)
                            } catch (e: JSONException) {
                                Log.d("Error", e.message.toString())
                            }
                        },
                        Response.ErrorListener {
                            Toast.makeText(applicationContext, "No Internet", Toast.LENGTH_LONG).show()


                        })
                    {
                        override fun getParams(): MutableMap<String, String>?
                        {
                            var map = HashMap<String, String>()
                            map["id"] = m.id.toString()


                            return map
                        }

                    }
                    var queue: RequestQueue = Volley.newRequestQueue(this)
                    queue.add(stringRequest)

                })
                alertDialog.setNegativeButton("NO",{ dialogInterface: DialogInterface, i: Int ->

                    dialogInterface.cancel()

                })
                alertDialog.show()
            }

        }

        return super.onContextItemSelected(item)
    }
}