package com.luckgg.domain.repository

import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import com.luckgg.domain.model.CatImage

interface CatRepository {
    suspend fun fetchCats(): Resource<List<Cat>>

    suspend fun searchCats(query: String): Resource<List<Cat>>

    suspend fun fetchCatImage(id: String): Resource<CatImage>
}
