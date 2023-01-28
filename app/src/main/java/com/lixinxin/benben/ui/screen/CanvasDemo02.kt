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

            val listData = listOf(100, 500, 200, 180, 400, 100, 800, 300, 700, 350)
            val mWith = 100f
            val mLeft = 100f

            linePath.moveTo(0f +mLeft, 0f)
            linePath.moveTo(0f +mLeft, listData[0] * 1f)

            linePath2.moveTo(0f +mLeft, listData[0] * 1f)
            for (index in 0 until listData.size) {
              //  linePath.lineTo(index * mWith , listData[index] * 1f)
               // linePath2.lineTo(index * mWith +, listData[index] * 1f)
            }

            for (index in 0 until listData.size - 1) {
                val xMoveDistance = 20
                val yMoveDistance = 40

                if (listData[index] == listData[index + 1]) {
                    linePath.lineTo(mWith*(index+1) +mLeft,listData[index + 1]*1f )
                    linePath2.lineTo(mWith*(index+1)+mLeft ,listData[index + 1]*1f )
                } else if (listData[index] < listData[index + 1]) {//y1<y2情况
                    val centerX = (mWith * index + mWith * (1 + index)) / 2
                    val centerY =
                        (listData[index].toFloat()  + listData[index + 1].toFloat() ) / 2
                    val controX0 = (mWith * index + centerX) / 2
                    val controY0 = (listData[index].toFloat()  + centerY) / 2
                    val controX1 = (centerX + mWith * (1 + index)) / 2
                    val controY1 = (centerY + listData[index + 1].toFloat() ) / 2
                    linePath.cubicTo(
                        controX0 + xMoveDistance+mLeft,
                        controY0 - yMoveDistance,
                        controX1 - xMoveDistance+mLeft,
                        controY1 + yMoveDistance,
                        mWith * (1 + index)+mLeft,
                        listData[index + 1].toFloat()
                    )

                    linePath2.cubicTo(
                        controX0 + xMoveDistance+mLeft,
                        controY0 - yMoveDistance,
                        controX1 - xMoveDistance+mLeft,
                        controY1 + yMoveDistance,
                        mWith * (1 + index)+mLeft,
                        listData[index + 1].toFloat()
                    )
                } else {
                    val centerX = (mWith * index + mWith * (1 + index)) / 2
                    val centerY =
                        (listData[index].toFloat()  + listData[index + 1].toFloat() ) / 2
                    val controX0 = (mWith * index + centerX) / 2
                    val controY0 = (listData[index].toFloat()  + centerY) / 2
                    val controX1 = (centerX + mWith * (1 + index)) / 2
                    val controY1 = (centerY + listData[index + 1].toFloat() ) / 2
                    linePath.cubicTo(
                        controX0 + xMoveDistance+mLeft,
                        controY0 + yMoveDistance,
                        controX1 - xMoveDistance+mLeft,
                        controY1 - yMoveDistance,
                        mWith * (1 + index)+mLeft,
                        listData[index + 1].toFloat()
                    )

                    linePath2.cubicTo(
                        controX0 + xMoveDistance+mLeft,
                        controY0 + yMoveDistance,
                        controX1 - xMoveDistance+mLeft,
                        controY1 - yMoveDistance,
                        mWith * (1 + index)+mLeft,
                        listData[index + 1].toFloat()
                    )
                }
            }


            linePath.lineTo(mWith * (listData.size - 1)+mLeft , 0f)
            linePath.lineTo(0f+mLeft, 0f)

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
                    mWith * index+mLeft,
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
