package com.luckgg.network.remote.source

import com.luckgg.network.CatAPI
import com.luckgg.network.remote.RemoteSource
import com.luckgg.network.remote.dto.CatDTO
import com.luckgg.network.remote.dto.CatImageDTO
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
