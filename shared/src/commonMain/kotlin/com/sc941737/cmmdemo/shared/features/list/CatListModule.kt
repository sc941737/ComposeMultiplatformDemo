package com.sc941737.cmmdemo.shared.features.list

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val catListModule = module {
    factoryOf(::CatListViewModel)
}