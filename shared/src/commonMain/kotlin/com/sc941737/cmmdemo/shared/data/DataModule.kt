package com.sc941737.cmmdemo.shared.data

import com.sc941737.cmmdemo.shared.data.remote.CatService
import com.sc941737.cmmdemo.shared.data.remote.CatServiceImpl
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val dataModule = module {
    singleOf(::CatServiceImpl) bind CatService::class
    singleOf(::MyCatRepositoryImpl) bind MyCatRepository::class
}