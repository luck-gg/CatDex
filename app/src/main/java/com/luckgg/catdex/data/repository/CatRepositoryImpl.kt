package com.luckgg.catdex.data.repository

import com.luckgg.catdex.domain.model.Cat
import com.luckgg.catdex.domain.repository.CatRepository

class CatRepositoryImpl : CatRepository {
    override suspend fun getCats(): List<Cat> {
        TODO("Not yet implemented")
    }
}
