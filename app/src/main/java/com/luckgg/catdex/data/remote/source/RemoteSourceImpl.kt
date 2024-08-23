package com.luckgg.catdex.data.remote.source

import com.luckgg.catdex.data.CatAPI
import com.luckgg.catdex.data.remote.RemoteSource
import com.luckgg.catdex.data.remote.dto.CatDTO
import com.luckgg.catdex.data.remote.dto.CatImageDTO
import javax.inject.Inject

class RemoteSourceImpl
    @Inject
    constructor(
        private val apiService: CatAPI,
    ) : RemoteSource {
        override suspend fun getCats(): List<CatDTO> = apiService.getCats()

        override suspend fun searchCats(query: String): List<CatDTO> = apiService.searchCats(query)

        override suspend fun getCatImage(id: String): CatImageDTO = apiService.getCatImage(id)
    }
