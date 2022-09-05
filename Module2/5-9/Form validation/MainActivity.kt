
package com.example.mysecondapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var edt1:EditText
    lateinit var edt2:EditText

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1=findViewById(R.id.btn1)
        edt1=findViewById(R.id.edt1)
        edt2=findViewById(R.id.edt2)

        btn1.setOnClickListener()
        {

            var n = edt1.text.toString()
            var p = edt2.text.toString()

            if(n.length==0 && p.length==0)
            {
                edt1.setError("Please Enter Mobile Number")
                edt2.setError("Please Enter Password")
            }
            else if(n.length==0)
            {
                edt1.setError("Please Enter Mobile Number")
            }
            else if(p.length==0)
            {
                edt2.setError("Please Enter Password")
            }

            else
            {
                if(n.equals("99999") && p.equals("123"))
                {
                    Toast.makeText(applicationContext,"Login Success",Toast.LENGTH_LONG).show()
                    var i =Intent(this,MainActivity2::class.java)
                    startActivity(i)
                }
                else
                {
                    Toast.makeText(applicationContext,"Login Fail",Toast.LENGTH_LONG).show()

                }


            }

        }

    }

    override fun onBackPressed() {
        finishAffinity()
    }

}