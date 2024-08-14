package com.luckgg.catdex.data.mapper

import com.luckgg.catdex.data.remote.dto.CatDTO
import com.luckgg.catdex.domain.model.Cat

class CatMapper {
    private fun mapToDomainCat(catDTO: CatDTO): Cat =
        Cat(
            breed = catDTO.name,
            baseColor = catDTO.origin,
        )

    fun mapToDomainCats(catDTOs: List<CatDTO>): List<Cat> = catDTOs.map { mapToDomainCat(it) }
}
