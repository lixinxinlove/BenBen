package com.lixinxin.benben.ui.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.graphics.Color

@Immutable
data class CustomColors(
    val content: Color,
    val component: Color,
    val background: List<Color>
)
