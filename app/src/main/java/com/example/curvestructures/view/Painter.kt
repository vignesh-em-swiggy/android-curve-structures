package com.example.curvestructures.view

import android.graphics.Canvas
import android.graphics.Paint
import androidx.annotation.ColorInt

class Painter(@ColorInt color: Int) {

    private val paint = Paint().also { it.color = color }

    fun paint(canvas: Canvas) {

    }
}
