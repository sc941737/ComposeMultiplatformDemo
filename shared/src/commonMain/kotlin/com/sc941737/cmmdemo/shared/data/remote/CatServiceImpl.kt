package com.sc941737.cmmdemo.shared.data.remote

import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.request

class CatServiceImpl(
    private val client: HttpClient,
) : CatService {
    override suspend fun fetchCats(): List<ApiCat> =
        client.request("https://cataas.com/api/cats?limit=100").body()
}