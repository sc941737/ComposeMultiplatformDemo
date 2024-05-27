package com.sc941737.cmmdemo.shared.common.main

import com.sc941737.cmmdemo.shared.data.dataModule
import com.sc941737.cmmdemo.shared.data.local.localDataModule
import com.sc941737.cmmdemo.shared.features.details.detailModule
import com.sc941737.cmmdemo.shared.features.list.catListModule
import com.sc941737.cmmdemo.shared.features.myCat.myCatModule
import com.sc941737.cmmdemo.shared.network.networkModule
import kotlinx.coroutines.CoroutineScope
import org.koin.dsl.module
import kotlin.coroutines.CoroutineContext
import kotlin.coroutines.EmptyCoroutineContext

fun appModule() = listOf(
    coroutineModule,
    localDataModule,
    networkModule,
    dataModule,
    catListModule,
    detailModule,
    myCatModule,
)

private val coroutineModule = module {
    single<CoroutineContext> { EmptyCoroutineContext }
    single<CoroutineScope> { CoroutineScope(get()) }
}