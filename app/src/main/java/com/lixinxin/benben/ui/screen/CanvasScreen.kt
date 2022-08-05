package com.lixinxin.benben.ui.screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.room.PrimaryKey


@Composable
fun CanvasScreen() {


    BoxWithConstraints(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {

        val mConstraints = constraints

        Column(modifier = Modifier.fillMaxSize()) {

            Canvas(modifier = Modifier.fillMaxSize(), onDraw = {

                drawCircle(
                    color = Color.Green,
                    radius = mConstraints.maxWidth.toFloat() / 2 - 10F,
                    style = Stroke(width = 10F)
                )

            })
        }


    }

}

@Composable
@Preview
private fun CanvasScreenPreview() {
    CanvasScreen()
}
