package com.sc941737.cmmdemo.shared.util

import android.content.Context
import com.sc941737.cmmdemo.shared.common.main.appModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

fun initKoin(context: Context) {
    startKoin {
        androidContext(context)
        modules(appModule())
    }
}