package com.sc941737.cmmdemo.shared.features.myCat

import cafe.adriel.voyager.core.model.ScreenModel
import com.sc941737.cmmdemo.shared.data.MyCatRepository

class MyCatViewModel(
    private val catRepository: MyCatRepository,
) : ScreenModel {
    val myCat = catRepository.myCat

    fun adoptNewCat() {
        catRepository.adoptNew()
    }

}