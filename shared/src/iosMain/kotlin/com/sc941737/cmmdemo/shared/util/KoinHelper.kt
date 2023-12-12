package com.sc941737.cmmdemo.shared.util

import com.sc941737.cmmdemo.shared.common.main.appModule
import org.koin.core.context.startKoin

fun initKoin() {
    startKoin {
        modules(appModule())
    }
}