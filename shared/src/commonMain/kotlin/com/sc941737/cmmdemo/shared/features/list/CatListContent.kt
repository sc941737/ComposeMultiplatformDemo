package com.sc941737.cmmdemo.shared.features.list

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.unit.dp
import com.sc941737.cmmdemo.shared.ui.CatPic
import com.sc941737.cmmdemo.shared.util.rememberOpenPickerAction
import com.seiko.imageloader.rememberImagePainter

@Composable
fun CatListContent(
    platformName: String,
    catPics: List<CatPic>,
    imageText: String,
    onImageTextChanged: (String) -> Unit,
    onGeneratePicClicked: () -> Unit,
    onImageSelected: (ImageBitmap) -> Unit,
    onImageClicked: (CatPic) -> Unit,
    onMyCatClicked: () -> Unit,
) {
    Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Running on $platformName")
        OutlinedTextField(
            value = imageText,
            onValueChange = onImageTextChanged,
        )
        Row {
            Button(
                onClick = onGeneratePicClicked,
            ) {
                Text("Generate cat pic")
            }
            Spacer(modifier = Modifier.size(4.dp))
            Button(
                onClick = rememberOpenPickerAction(onImageSelected = onImageSelected),
            ) {
                Text("Pick cat pic")
            }
        }
        Button(
            onClick = onMyCatClicked,
        ) {
            Text("My cat")
        }
        LazyColumn(
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            items(catPics, null) {
                val modifier = Modifier.padding(4.dp)
                    .heightIn(max = 200.dp)
                    .clickable { onImageClicked(it) }
                when (it) {
                    is CatPic.Web -> {
                        val painter = rememberImagePainter(it.url)
                        Image(
                            painter = painter,
                            contentDescription = null,
                            modifier = modifier,
                        )
                    }
                    is CatPic.Local -> {
                        Image(
                            bitmap = it.bytes,
                            contentDescription = null,
                            modifier = modifier,
                        )
                    }
                }
            }
        }
    }
}