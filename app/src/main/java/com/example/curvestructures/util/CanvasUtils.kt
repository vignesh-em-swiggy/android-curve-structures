package com.example.curvestructures.util

import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.PointF
import android.graphics.RectF
import androidx.annotation.ColorInt

fun Canvas.drawRect(rect: RectF, @ColorInt color: Int) {
    drawRect(rect, Paint().apply { this.color = color })
}

fun Canvas.plotPoints(points: List<PointF>, @ColorInt color: Int) {
    points.forEach { plotPoint(it, color) }
}

private fun Canvas.plotPoint(point: PointF, @ColorInt color: Int) {
    drawCircle(point.x, point.y, 5f, Paint().apply { this.color = color })
}