package com.lixinxin.benben.view

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.Layout

//自定义view

@Composable
fun MyBasicColumn(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {

    Layout(content = content, modifier = modifier) {
        //可以测量的元素
            measures,
            //可组合项的传入约束条件
            constraints ->

        val placeable = measures.map { measure ->
            measure.measure(constraints)
        }


        layout(constraints.maxWidth, constraints.maxHeight) {
            var yPosition = 0

            placeable.forEach {
                it.placeRelative(x = 0, y = yPosition)
                yPosition += it.height
            }

        }

    }


}