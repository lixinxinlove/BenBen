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


    Layout(content = content, modifier = modifier) { measurables, constraints ->


        layout(100, 100) {}

    }


}