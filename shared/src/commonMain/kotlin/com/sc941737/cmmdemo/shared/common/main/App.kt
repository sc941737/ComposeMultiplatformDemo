package com.sc941737.cmmdemo.shared.common.main

import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.sc941737.cmmdemo.shared.features.list.CatListScreen
import org.koin.compose.KoinContext

@Composable
fun App() {
    KoinContext {
        AppTheme {
            Navigator(CatListScreen)
        }
    }
}