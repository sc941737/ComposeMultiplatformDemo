package com.sc941737.cmmdemo.shared.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.ImageBitmap

@Composable
expect fun rememberOpenPickerAction(onImageSelected: (ImageBitmap) -> Unit): () -> Unit