package com.example.curvestructures.view

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import androidx.annotation.ColorInt

class Painter(@ColorInt color: Int, private val resources: Resources) {

    private val paint = Paint().also { it.color = color }

    fun paint(canvas: Canvas) {
        canvas.drawPath(getPath(canvas), paint)
    }

    private fun getPath(canvas: Canvas) = Path()
}
