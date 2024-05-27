package com.sc941737.cmmdemo.shared.data

import com.liftric.kvault.KVault
import com.sc941737.cmmdemo.shared.BuildKonfig
import com.sc941737.cmmdemo.shared.data.remote.CatService
import com.sc941737.cmmdemo.shared.features.myCat.MyCat
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

const val MY_CAT_ID = "MY_CAT_ID"

class MyCatRepositoryImpl(
    private val service: CatService,
    private val scope: CoroutineScope,
    private val localDataStore: KVault,
) : MyCatRepository {
    private val _myCat = MutableStateFlow<MyCat?>(null)
    override val myCat = _myCat.asStateFlow()

    init {
        localDataStore.string(forKey = MY_CAT_ID)?.let { id ->
            _myCat.update { MyCat(id, BuildKonfig.BASE_URL) }
        }
    }

    override fun adoptNew() {
        scope.launch {
            val newCat = service.fetchCats()
                .shuffled()
                .firstOrNull()
                ?: return@launch
            val myNewCat = MyCat(
                id = newCat.id,
                _baseUrl = BuildKonfig.BASE_URL
            )
            _myCat.update { myNewCat }
            localDataStore.set(MY_CAT_ID, myNewCat.id)
        }
    }
}