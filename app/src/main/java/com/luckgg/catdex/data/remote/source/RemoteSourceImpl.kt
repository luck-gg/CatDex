package com.luckgg.catdex.data.remote.source

import com.luckgg.catdex.data.CatAPI
import com.luckgg.catdex.data.mapper.CatMapper
import com.luckgg.catdex.data.remote.RemoteSource
import com.luckgg.catdex.domain.model.Cat
import javax.inject.Inject

class RemoteSourceImpl
    @Inject
    constructor(
        private val apiService: CatAPI,
    ) : RemoteSource {
        private val mapper = CatMapper()

        override suspend fun getCats(): List<Cat> = mapper.mapToDomainCats(apiService.getCats().list)

        override suspend fun searchCats(query: String): List<Cat> = mapper.mapToDomainCats(apiService.searchCats(query).list)
    }
