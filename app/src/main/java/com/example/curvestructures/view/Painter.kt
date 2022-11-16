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
        val mainRectHeight = canvasHeight - resources.getDimension(R.dimen.dp48)

        val squareSide = resources.getDimension(R.dimen.dp32)
        val square1 = RectFFactory.fromLTWH(0f, 0f, squareSide, squareSide)
        val square2 = RectFFactory.fromLTWH(canvasWidth - squareSide, 0f, squareSide, squareSide)
        val square3 = RectFFactory.fromLTWH(canvasWidth - squareSide,
            mainRectHeight - squareSide,
            squareSide,
            squareSide)
        val square4 = RectFFactory.fromLTWH(0f, mainRectHeight - squareSide, squareSide, squareSide)

        val tailWidth = resources.getDimension(R.dimen.dp48)
        val tailHeight = resources.getDimension(R.dimen.dp48)
        val square5 = RectFFactory.fromLTWH((canvasWidth - tailWidth) / 2,
            canvasHeight - tailHeight,
            tailWidth,
            tailHeight)

        canvas.drawRect(square5, Color.RED)

        canvas.drawRect(square1, Color.RED)
        canvas.drawRect(square2, Color.RED)
        canvas.drawRect(square3, Color.RED)
        canvas.drawRect(square4, Color.RED)

        arcTo(square1, 180f, 90f)
        arcTo(square2, 270f, 90f)
        arcTo(square3, 0f, 90f)
        arcTo(square4, 90f, 90f)
    }
}
