package com.sc941737.cmmdemo.shared.features.myCat

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow

object MyCatScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = getScreenModel<MyCatViewModel>()
        val myCat by viewModel.myCat.collectAsState()
        MyCatContent(
            onAdoptNewClicked = viewModel::adoptNewCat,
            onBackClicked = navigator::pop,
            myCat = myCat,
        )
    }


}