package com.luckgg.network.remote.source

import com.luckgg.network.api.CatAPI
import com.luckgg.network.remote.RemoteSource
import com.luckgg.network.remote.dto.CatDTO
import com.luckgg.network.remote.dto.CatImageDTO
import javax.inject.Inject

class RemoteSourceImpl
    @Inject
    constructor(
        private val apiService: CatAPI,
    ) : RemoteSource {
        override suspend fun fetchCats(
            limit: Int,
            page: Int,
        ): List<CatDTO> = apiService.getCats(limit, page)

        override suspend fun searchCats(query: String): List<CatDTO> = apiService.searchCats(query)

        override suspend fun fetchCatImage(id: String): CatImageDTO = apiService.getCatImage(id)
    }
