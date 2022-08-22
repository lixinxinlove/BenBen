package com.lixinxin.benben.ui.screen

import android.graphics.LinearGradient
import android.graphics.Paint
import android.graphics.Shader
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.nativeCanvas
import androidx.compose.ui.tooling.preview.Preview


@Composable
fun CanvasDemo02() {

    Canvas(modifier = Modifier.fillMaxSize()) {
        drawIntoCanvas {

            //坐标转成数学坐标
            it.scale(1f, -1f)
            it.translate(0f, -size.height)

            val linePath = android.graphics.Path()
            val linePath2 = android.graphics.Path()

            val listData = listOf(100, 500, 200, 180, 400, 100, 800, 100, 700, 200)
            val mWith = 100f
            val left = 80f

            linePath.moveTo(0f + left, 0f)
            linePath2.moveTo(0f + left, listData[0] * 1f)
            for (index in 0 until listData.size) {
                linePath.lineTo(index * mWith + left, listData[index] * 1f)
                linePath2.lineTo(index * mWith + left, listData[index] * 1f)
            }

            linePath.lineTo(mWith * (listData.size - 1) + left, 0f)
            linePath.lineTo(0f, 0f)

            val linearGradient = LinearGradient(
                0f, 800f,
                0f,
                0f,
                android.graphics.Color.argb(255, 229, 160, 144),
                android.graphics.Color.argb(255, 251, 244, 240),
                Shader.TileMode.CLAMP
            )




            val linePaint = Paint()
            linePaint.strokeWidth = 2f
            linePaint.style = Paint.Style.FILL
            linePaint.color = android.graphics.Color.argb(100, 111, 111, 111)
            linePaint.shader = linearGradient
            it.nativeCanvas.drawPath(linePath, linePaint)

            linePaint.strokeWidth = 4f
            linePaint.style = Paint.Style.STROKE
            linePaint.color = android.graphics.Color.argb(255, 212, 100, 77)

            it.nativeCanvas.drawPath(linePath2, linePaint)



            linePaint.style = Paint.Style.FILL
            //画圈。
            for (index in 0 until listData.size) {
                it.nativeCanvas.drawCircle(
                    mWith * index+left,
                     listData[index]*1f,
                    8f,
                    linePaint
                )
            }

        }
    }


}


@Composable
@Preview
fun CanvasDemo02Preview() {
    CanvasDemo02()
}
