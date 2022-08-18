package com.lixinxin.benben.ui.data

import androidx.compose.runtime.Immutable
import androidx.compose.ui.unit.Dp

@Immutable
data class CustomElevation(
    val default: Dp,
    val pressed: Dp
)