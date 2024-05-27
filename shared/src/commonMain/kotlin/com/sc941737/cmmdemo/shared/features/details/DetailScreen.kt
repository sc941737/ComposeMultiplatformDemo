package com.sc941737.cmmdemo.shared.features.details

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.sc941737.cmmdemo.shared.ui.CatPic

data class DetailScreen(val catPic: CatPic) : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<DetailsViewModel>()
        DetailContent(
            catPic = catPic,
            onBackClicked = { navigator.pop() },
        )
    }
}