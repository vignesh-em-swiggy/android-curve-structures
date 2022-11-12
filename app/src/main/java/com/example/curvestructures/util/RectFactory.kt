package com.example.curvestructures.util

import android.graphics.PointF
import android.graphics.RectF

object RectFFactory {
    fun fromLTRB(left: Float, top: Float, right: Float, bottom: Float) =
        RectF(left, top, right, bottom)

    fun fromLTWH(left: Float, top: Float, width: Float, height: Float) =
        fromLTRB(left, top, left + width, top + height)

    fun fromCircle(center: PointF, radius: Float) =
        fromCenter(
            center = center,
            width = radius * 2,
            height = radius * 2
        )

    fun fromCenter(center: PointF, width: Float, height: Float) =
        fromLTRB(
            center.x - width / 2,
            center.y - height / 2,
            center.x + width / 2,
            center.y + height / 2
        )
}

val RectF.topRight: PointF get() = PointF(right, top)

val RectF.topLeft: PointF get() = PointF(left, top)

val RectF.centerLeft: PointF get() = PointF(left, top + height() / 2.0f)

val RectF.centerRight: PointF get() = PointF(right, top + height() / 2.0f)

val RectF.centerBottom: PointF get() = PointF(left + width() / 2.0f, bottom)

val RectF.centerTop: PointF get() = PointF(left + width() / 2.0f, top)

val RectF.bottomLeft: PointF get() = PointF(left, bottom)

val RectF.bottomRight: PointF get() = PointF(right, bottom)