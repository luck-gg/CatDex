package com.luckgg.catdex.domain.repository

import com.luckgg.catdex.common.Resource
import com.luckgg.catdex.domain.model.Cat
import com.luckgg.catdex.domain.model.CatImage

interface CatRepository {
    suspend fun getCats(): Resource<List<Cat>>

    suspend fun searchCats(query: String): Resource<List<Cat>>

    suspend fun getCatImage(id: String): Resource<CatImage>
}
