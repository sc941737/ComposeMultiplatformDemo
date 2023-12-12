package com.sc941737.cmmdemo.shared.features.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.sc941737.cmmdemo.shared.features.details.DetailScreen
import com.sc941737.cmmdemo.shared.features.myCat.MyCatScreen
import com.sc941737.cmmdemo.shared.util.getPlatformName

object CatListScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<CatListViewModel>()
        val catPics by viewModel.catPics.collectAsState()
        val imageText by viewModel.imageText.collectAsState()
        CatListContent(
            platformName = getPlatformName(),
            catPics = catPics,
            imageText = imageText,
            onImageTextChanged = viewModel::updateImageText,
            onGeneratePicClicked = viewModel::addCatPic,
            onImageSelected = viewModel::addCatPic,
            onImageClicked = { navigator.push(DetailScreen(it)) },
            onMyCatClicked = { navigator.push(MyCatScreen) },
        )
    }
}

