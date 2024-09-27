package com.luckgg.network.remote

import com.luckgg.network.remote.dto.CatDTO
import com.luckgg.network.remote.dto.CatImageDTO

interface RemoteSource {
    suspend fun getCats(): List<CatDTO>

    suspend fun searchCats(query: String): List<CatDTO>

    suspend fun getCatImage(id: String): CatImageDTO
}
