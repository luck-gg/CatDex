package com.luckgg.catdex.data.remote

import com.luckgg.catdex.data.remote.dto.CatDTO
import com.luckgg.catdex.data.remote.dto.CatImageDTO

interface RemoteSource {
    suspend fun getCats(): List<CatDTO>

    suspend fun searchCats(query: String): List<CatDTO>

    suspend fun getCatImage(id: String): CatImageDTO
}
