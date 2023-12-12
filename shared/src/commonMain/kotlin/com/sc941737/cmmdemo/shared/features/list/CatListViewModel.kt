package com.sc941737.cmmdemo.shared.features.list

import androidx.compose.ui.graphics.ImageBitmap
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.sc941737.cmmdemo.shared.BuildKonfig
import com.sc941737.cmmdemo.shared.ui.CatPic
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update

class CatListViewModel : ScreenModel {
    private val baseUrl = BuildKonfig.BASE_URL

    private val _fontSize = MutableStateFlow(60) // hardcoded for now
    fun updateFontSize(size: Int) = _fontSize.update { size }
    val fontSize = _fontSize.asStateFlow()

    private val _fontColor = MutableStateFlow("red") // hardcoded for now
    fun updateFontColor(color: String) = _fontColor.update { color }
    val fontColor = _fontColor.asStateFlow()

    private val _imageText = MutableStateFlow("")
    fun updateImageText(s: String) = _imageText.update { s }
    val imageText = _imageText.asStateFlow()

    private val imageUrl = combine(
        imageText,
        fontSize,
        fontColor,
    ) { text, size, color ->
        if (text.isEmpty()) baseUrl
        else "$baseUrl/says/$text?fontSize=$size&fontColor=$color"
    }.stateIn(screenModelScope, SharingStarted.Eagerly, "")

    private val _catPics = MutableStateFlow<List<CatPic>>(emptyList())
    fun addCatPic() {
        val url  = imageUrl.value.takeIf { it.isNotEmpty() } ?: return
        val newPic = CatPic.Web(url)
        _catPics.update { it.plus(newPic) }
    }
    fun addCatPic(bitmap: ImageBitmap) {
        val newPic = CatPic.Local(bytes = bitmap)
        _catPics.update { it.plus(newPic) }
    }
    val catPics = _catPics
        .map { it.reversed() }
        .stateIn(screenModelScope, SharingStarted.WhileSubscribed(5000L), emptyList())
}