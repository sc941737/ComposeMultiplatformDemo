package com.sc941737.cmmdemo.shared.data

import com.sc941737.cmmdemo.shared.features.myCat.MyCat
import kotlinx.coroutines.flow.StateFlow

interface MyCatRepository {
    val myCat: StateFlow<MyCat?>
    fun adoptNew()
}
