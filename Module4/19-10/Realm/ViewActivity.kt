package com.example.realmex

import android.annotation.SuppressLint
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.AdapterView
import android.widget.EditText
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import io.realm.Realm

class ViewActivity : AppCompatActivity(), AdapterView.OnItemLongClickListener {
    lateinit var listView: ListView
    lateinit var list: MutableList<Model>
    lateinit var realm: Realm

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view)

        listView = findViewById(R.id.list)
        list = ArrayList()
        realm= Realm.getInstance(Realm.getDefaultConfiguration())

            realm.beginTransaction()

           var realmResults = realm.where(Model::class.java).findAll()

            for(i in realmResults.indices)
            {
                    list.add(realmResults[i]!!)
            }

            var adapter =MyAdapter(applicationContext,list)
            listView.adapter=adapter

            realm.commitTransaction()

        listView.setOnItemLongClickListener(this)
    }

    override fun onItemLongClick(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long): Boolean
    {

            var alertDialog=AlertDialog.Builder(this)
            alertDialog.setTitle("Select Operations?")
            alertDialog.setPositiveButton("UPDATE",{
                    dialogInterface: DialogInterface, i: Int ->

                var alertDialog2=AlertDialog.Builder(this)
                var inflater=LayoutInflater.from(this)
                var view =inflater.inflate(R.layout.edit,null)
                var edit1:EditText =view.findViewById(R.id.edt1)
                var edit2:EditText =view.findViewById(R.id.edt2)

                realm.beginTransaction()
                var realmResults = realm.where(Model::class.java).findAll()

                edit1.setText(realmResults.get(p2)!!.name)
                edit2.setText(realmResults.get(p2)!!.pass)

                realm.commitTransaction()


                alertDialog2.setView(view)
                alertDialog2.setPositiveButton("Edit",{ dialogInterface: DialogInterface, i: Int ->

                    var name =edit1.text.toString()
                    var pass=edit2.text.toString()


                    realm.beginTransaction()

                    list.get(p2).name =name
                    list.get(p2).pass =pass


                    realm.commitTransaction()
                    startActivity(Intent(this,ViewActivity::class.java))


                })
                alertDialog2.show()

            })
        alertDialog.setNegativeButton("DELETE",{
                dialogInterface: DialogInterface, i: Int ->

            realm.beginTransaction()
            var realmResults = realm.where(Model::class.java).findAll()
            realmResults.deleteFromRealm(p2)
            realm.commitTransaction()
            startActivity(Intent(this,ViewActivity::class.java))


        })
        alertDialog.show()

        return true
    }
}