package com.sc941737.cmmdemo.shared.features.myCat

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.sc941737.cmmdemo.shared.ui.MyTopBar
import com.seiko.imageloader.rememberImagePainter

@Composable
fun MyCatContent(
    myCat: MyCat?,
    onAdoptNewClicked: () -> Unit,
    onBackClicked: () -> Unit,
) {
    Scaffold(
        topBar = {
            MyTopBar(
                title = "My Cat",
                onBackClicked = onBackClicked,
            )
        },
        content = {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                myCat?.let {
                    val painter = rememberImagePainter(it.url)
                    Image(
                        painter = painter,
                        contentDescription = null,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "id: ${it.id}",
                        modifier = Modifier.padding(12.dp)
                    )
                }
            }
        },
        bottomBar = {
            Row(
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxWidth()
            ) {
                Button(
                    onClick = onAdoptNewClicked,
                ) {
                    Text("Adopt new")
                }
            }
        }
    )
}
