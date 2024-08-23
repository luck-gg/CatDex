package com.luckgg.catdex.data.remote.dto

import com.google.gson.annotations.SerializedName

data class CatImageDTO(
    @SerializedName("height") val height: Int,
    val breeds: List<CatDTO>,
    val id: String,
    val url: String,
    val width: Int,
)
