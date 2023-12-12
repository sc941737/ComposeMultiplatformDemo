package com.sc941737.cmmdemo.shared.ui

import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.Composable

@Composable
fun MyTopBar(
    title: String,
    onBackClicked: () -> Unit,
) {
    TopAppBar(
        title = { Text(title) },
        navigationIcon = {
            IconButton(
                onClick = onBackClicked,
            ) {
                Icon(Icons.Default.ArrowBack, null)
            }
        }
    )
}