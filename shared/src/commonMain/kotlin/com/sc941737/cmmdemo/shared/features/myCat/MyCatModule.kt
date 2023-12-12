package com.sc941737.cmmdemo.shared.features.myCat

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val myCatModule = module {
    factoryOf(::MyCatViewModel)
}