package com.sc941737.cmmdemo.shared.features.details

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.module

val detailModule = module {
    factoryOf(::DetailsViewModel)
}