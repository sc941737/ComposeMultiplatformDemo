package com.sc941737.cmmdemo.shared.features.myCat

data class MyCat(
    val id: String,
    private val _baseUrl: String,
) {
    val url get() = "$_baseUrl/$id"
}