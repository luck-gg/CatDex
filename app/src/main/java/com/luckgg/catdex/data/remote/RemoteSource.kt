package com.luckgg.catdex.data.remote

import com.luckgg.catdex.domain.model.Cat

interface RemoteSource {
    suspend fun getCats(): List<Cat>

    suspend fun searchCats(query: String): List<Cat>
}
