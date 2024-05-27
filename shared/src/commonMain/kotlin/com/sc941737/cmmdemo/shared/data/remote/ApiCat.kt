package com.sc941737.cmmdemo.shared.data.remote

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class ApiCat(
    @SerialName("_id") val id: String,
    @SerialName("tags") val tags: List<String>,
    @SerialName("size") val size: Int,
    @SerialName("mimetype") val mimeType: String,
)