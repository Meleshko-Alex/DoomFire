package com.example.doomfire

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import androidx.core.graphics.createBitmap

class DoomFireView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {

    private lateinit var temp: Array<IntArray>
    private val paint = Paint()
    private lateinit var bitmap: Bitmap

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)

        for (y in temp.indices) {
            for (x in temp[y].indices) {
                val color = firePalette[temp[y][x]]
                paint.color = color
                bitmap.setPixel(x, y, color)
            }
        }
        canvas.drawBitmap(bitmap, 0f, 0f, paint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)

        bitmap = createBitmap(w, h)
        temp = Array(h) { IntArray(w) }
        for (x in 0 until w) {
            temp[h - 1][x] = firePalette.size - 1
        }
    }

    private companion object {
        private val firePalette = intArrayOf(
            -0xf8f8f9,
            -0xe0f8f9,
            -0xd0f0f9,
            -0xb8f0f9,
            -0xa8e8f9,
            -0x98e0f9,
            -0x88e0f9,
            -0x70d8f9,
            -0x60d0f9,
            -0x50c0f9,
            -0x40b8f9,
            -0x38b8f9,
            -0x20b0f9,
            -0x20a8f9,
            -0x20a8f9,
            -0x28a0f9,
            -0x28a0f9,
            -0x2898f1,
            -0x3090f1,
            -0x3088f1,
            -0x3080f1,
            -0x3078e9,
            -0x3878e9,
            -0x3870e9,
            -0x3868e1,
            -0x4060e1,
            -0x4060e1,
            -0x4058d9,
            -0x4058d9,
            -0x4050d1,
            -0x4850d1,
            -0x4848d1,
            -0x4848c9,
            -0x303091,
            -0x202061,
            -0x101039,
            -0x1,
        )
    }
}