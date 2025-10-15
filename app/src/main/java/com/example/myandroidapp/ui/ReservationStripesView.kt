package com.example.myandroidapp.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import kotlin.math.min

class ReservationStripesView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyle: Int = 0
) : View(context, attrs, defStyle) {

    private val stripePaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val stripes = mutableListOf<Int>()

    // Public API to set colors (as ARGB Ints)
    fun setStripeColors(colors: List<Int>) {
        stripes.clear()
        // Cap at 15 (requirement)
        stripes.addAll(colors.take(15))
        invalidate()
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        if (stripes.isEmpty()) return
        val availableHeight = height.toFloat()
        val stripeHeight =  (availableHeight / min(15, stripes.size)) * 0.6f // leave spacing
        val gap = (availableHeight - stripeHeight * stripes.size) / (stripes.size + 1)
        var y = gap
        stripes.forEach { color ->
            stripePaint.color = color
            canvas.drawRect(0f, y, width.toFloat(), y + stripeHeight, stripePaint)
            y += stripeHeight + gap
        }
    }
}