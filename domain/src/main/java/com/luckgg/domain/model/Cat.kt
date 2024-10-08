package com.luckgg.domain.model

import com.luckgg.common.Constants

data class Cat(
    val breedName: String,
    val baseColor: String,
    val origin: String,
    val description: String,
    val temperament: String,
    val lifeSpan: String,
    val weight: String,
    val imageId: String,
    var imageUrl: String = Constants.EMPTY_STRING,
)
