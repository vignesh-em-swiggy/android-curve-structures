package com.example.curvestructures.view

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import androidx.annotation.ColorInt
import com.example.curvestructures.R
import com.example.curvestructures.util.RectFFactory
import com.example.curvestructures.util.drawRect

class Painter(@ColorInt color: Int, private val resources: Resources) {

    private val paint = Paint().also { it.color = color }

    fun paint(canvas: Canvas) {
        canvas.drawPath(getPath(canvas), paint)
    }

    private fun getPath(canvas: Canvas) = Path().apply {

        val canvasWidth = canvas.width.toFloat()
        val canvasHeight = canvas.height.toFloat()

        val squareSide = resources.getDimension(R.dimen.dp32)
        val square1 = RectFFactory.fromLTWH(0f, 0f, squareSide, squareSide)
        val square2 = RectFFactory.fromLTWH(canvasWidth - squareSide, 0f, squareSide, squareSide)
        val square3 = RectFFactory.fromLTWH(canvasWidth - squareSide,
            canvasHeight - squareSide,
            squareSide,
            squareSide)
        val square4 = RectFFactory.fromLTWH(0f, canvasHeight - squareSide, squareSide, squareSide)

        canvas.drawRect(square1, Color.RED)
        canvas.drawRect(square2, Color.RED)
        canvas.drawRect(square3, Color.RED)
        canvas.drawRect(square4, Color.RED)
    }
}
