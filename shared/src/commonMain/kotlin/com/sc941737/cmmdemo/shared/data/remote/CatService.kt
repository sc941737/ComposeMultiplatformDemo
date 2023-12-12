package com.sc941737.cmmdemo.shared.data.remote

interface CatService {
    suspend fun fetchCats(): List<ApiCat>
}

