package com.example.myapplication

import android.app.DatePickerDialog
import android.app.DatePickerDialog.OnDateSetListener
import android.app.Dialog
import android.app.TimePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TimePicker
import android.widget.Toast
import androidx.fragment.app.DialogFragment
import java.util.*

class MainActivity : AppCompatActivity()
{
    lateinit var btn1:Button
    lateinit var btn2:Button
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)

        btn1.setOnClickListener {

            var m =Mydatepicker()
            m.show(supportFragmentManager,"select date")

        }
        btn2.setOnClickListener {

            var m =Mytimepicker()
            m.show(supportFragmentManager,"select time")
        }



    }

}
class Mydatepicker :DialogFragment(), OnDateSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var c = Calendar.getInstance()
        var day = c.get(Calendar.DAY_OF_MONTH)
        var month = c.get(Calendar.MONTH)
        var year = c.get(Calendar.YEAR)

        return DatePickerDialog(requireActivity(),this,year,month,day)
    }

    override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
        Toast.makeText(activity,"$p1 - $p2 - $p3",Toast.LENGTH_LONG).show()
    }
}
class Mytimepicker :DialogFragment(), TimePickerDialog.OnTimeSetListener {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog
    {
        var c = Calendar.getInstance()
        var hour = c.get(Calendar.HOUR_OF_DAY)
        var minute = c.get(Calendar.MINUTE)


        return TimePickerDialog(requireActivity(),this,hour,minute,true)
    }

    override fun onTimeSet(p0: TimePicker?, p1: Int, p2: Int) {
        Toast.makeText(activity,"$p1 : $p2 ",Toast.LENGTH_LONG).show()
    }


}
