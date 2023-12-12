package com.sc941737.cmmdemo.shared.data.local

import com.liftric.kvault.KVault
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

actual val localDataModule = module {
    single<KVault> { KVault(androidContext(), "myCat") }
}