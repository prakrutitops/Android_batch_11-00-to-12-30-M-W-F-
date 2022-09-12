package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.RatingBar
import android.widget.Toast

class ProgressbarActivity : AppCompatActivity(), View.OnClickListener,
    RatingBar.OnRatingBarChangeListener {
    lateinit var pb:ProgressBar
    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var rating:RatingBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_progressbar)

        pb=findViewById(R.id.pb)
        btn1=findViewById(R.id.btn1)
        btn2=findViewById(R.id.btn2)
        rating=findViewById(R.id.r1)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        rating.setOnRatingBarChangeListener(this)


    }

    override fun onClick(p0: View?)
    {
          if(p0==btn1)
          {
            pb.incrementProgressBy(1)
              setProgress(100*pb.progress)
          }
            if(p0==btn2)
            {
                pb.incrementProgressBy(-1)
                setProgress(100*pb.progress)
            }
    }

    override fun onRatingChanged(p0: RatingBar?, p1: Float, p2: Boolean)
    {
        var r =rating.rating
        Toast.makeText(applicationContext,""+r,Toast.LENGTH_LONG).show()
    }
}