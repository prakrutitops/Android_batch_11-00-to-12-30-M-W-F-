package com.quint.sensorex

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.View

class GraphicsEx1(context: Context?) : View(context)
{
    lateinit var paint:Paint

    override fun onDraw(canvas: Canvas?)
    {
        super.onDraw(canvas)
        paint = Paint()

        paint.setColor(Color.GREEN)
        paint.setStyle(Paint.Style.STROKE)
        canvas!!.drawCircle(100F,100F,75F,paint)


        paint.setColor(Color.RED)
        paint.setStyle(Paint.Style.FILL)
        canvas.drawRect(50F,50F,200F,100F,paint)
    }
}