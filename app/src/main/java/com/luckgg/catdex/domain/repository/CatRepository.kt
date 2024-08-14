package com.luckgg.catdex.domain.repository

import com.luckgg.catdex.domain.model.Cat

interface CatRepository {
    suspend fun getCats(): List<Cat>
}
