package com.lixinxin.benben.ui.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.text.TextStyle

@Immutable
data class CustomTypography(
    val body: TextStyle,
    val title: TextStyle
)