package com.sc941737.cmmdemo.shared.ui

import androidx.compose.ui.graphics.ImageBitmap

sealed class CatPic {
    data class Web(
        val url: String,
    ) : CatPic()
    data class Local(
        val bytes: ImageBitmap,
    ) : CatPic()
}