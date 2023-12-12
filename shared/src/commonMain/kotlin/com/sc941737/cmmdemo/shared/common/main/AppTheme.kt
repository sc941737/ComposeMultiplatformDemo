package com.sc941737.cmmdemo.shared.common.main

import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

val AppLightColorScheme = lightColors(
    primary = Color.Red,
    onPrimary = Color.White,
)

@Composable
fun AppTheme(
    content: @Composable () -> Unit,
) {
    MaterialTheme(
        colors = AppLightColorScheme,
        content = content,
    )
}