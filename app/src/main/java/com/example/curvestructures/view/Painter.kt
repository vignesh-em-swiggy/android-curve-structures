package com.example.curvestructures.view

import android.content.res.Resources
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.graphics.PointF
import androidx.annotation.ColorInt
import com.example.curvestructures.R
import com.example.curvestructures.util.RectFFactory
import com.example.curvestructures.util.bottomLeft
import com.example.curvestructures.util.bottomRight
import com.example.curvestructures.util.centerBottom
import com.example.curvestructures.util.drawRect
import com.example.curvestructures.util.midPoint
import com.example.curvestructures.util.plotPoints
import com.example.curvestructures.util.topLeft
import com.example.curvestructures.util.topRight

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

        val points = listOf(
            PointF(square5.topRight.x + (tailWidth * 0.5f), square5.topRight.y),
            square5.topRight,
            PointF(square5.topRight.x - (tailWidth * 0.1f),
                square5.topRight.y + (tailHeight * 0.5f)),
            PointF(square5.centerBottom.x + (tailWidth * 0.2f), square5.bottomRight.y - (tailHeight * 0.1f)),
            square5.centerBottom,
            PointF(square5.centerBottom.x - (tailWidth * 0.2f), square5.bottomLeft.y  - (tailHeight * 0.1f)),
            PointF(square5.topLeft.x + (tailWidth * 0.1f), square5.topLeft.y + (tailHeight * 0.5f)),
            square5.topLeft,
            PointF(square5.topLeft.x - (tailWidth * 0.5f), square5.topLeft.y),
        )

        canvas.drawRect(square1, Color.RED)
        canvas.drawRect(square2, Color.RED)
        canvas.drawRect(square3, Color.RED)
        canvas.drawRect(square4, Color.RED)

        arcTo(square1, 180f, 90f)
        arcTo(square2, 270f, 90f)
        arcTo(square3, 0f, 90f)
        points.first().run { lineTo(x, y) }
        drawQuadCurveThrough(this, points)
        points.last().run { lineTo(x, y) }
        arcTo(square4, 90f, 90f)

        canvas.plotPoints(points, Color.WHITE)
    }

    private fun drawQuadCurveThrough(path: Path, points: List<PointF>) {
        for (i in 0 until points.size - 1) {
            val p0 = points[i]
            val p1 = points[i + 1]
            val mid = midPoint(p0, p1)
            path.quadTo(p0.x, p0.y, mid.x, mid.y)
        }
    }
}
