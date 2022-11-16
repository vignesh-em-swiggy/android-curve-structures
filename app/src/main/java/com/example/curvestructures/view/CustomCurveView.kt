package com.example.curvestructures.view

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

class CustomCurveView @JvmOverloads constructor(
    context: Context,
    attributeSet: AttributeSet? = null,
    defStyleAttr: Int = 0,
    defStyleRes: Int = 0,
) : View(context, attributeSet, defStyleAttr, defStyleRes) {

    private val painter: Painter

    init {
        setBackgroundColor(Color.TRANSPARENT)
        painter = Painter(Color.BLACK, context.resources)
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let(painter::paint)
    }

}
