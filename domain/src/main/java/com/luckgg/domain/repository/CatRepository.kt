package com.luckgg.domain.repository

import androidx.paging.PagingData
import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import com.luckgg.domain.model.CatImage
import kotlinx.coroutines.flow.Flow

interface CatRepository {
    fun fetchCats(): Flow<PagingData<Cat>>

    suspend fun searchCats(query: String): Resource<List<Cat>>

    suspend fun fetchCatImage(id: String): Resource<CatImage>
}
