package com.sc941737.cmmdemo.shared.features.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.sc941737.cmmdemo.shared.ui.CatPic
import com.sc941737.cmmdemo.shared.ui.MyTopBar
import com.seiko.imageloader.rememberImagePainter

@Composable
fun DetailContent(
    catPic: CatPic,
    onBackClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            MyTopBar(
                title = "Meow",
                onBackClicked = onBackClicked,
            )
        },
        content = {
            val modifier = Modifier.fillMaxSize().padding(4.dp)
            when (catPic) {
                is CatPic.Web -> {
                    val painter = rememberImagePainter(catPic.url)
                    Image(
                        painter, null, modifier = modifier,
                    )
                }
                is CatPic.Local -> {
                    Image(
                        catPic.bytes, null, modifier = modifier,
                    )
                }
            }
        }
    )
}