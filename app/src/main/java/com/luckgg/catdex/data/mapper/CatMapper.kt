package com.luckgg.catdex.data.mapper

import com.luckgg.catdex.data.remote.dto.CatDTO
import com.luckgg.catdex.data.remote.dto.CatImageDTO
import com.luckgg.catdex.domain.model.Cat
import com.luckgg.catdex.domain.model.CatImage

class CatMapper {
    private fun mapToDomainCat(catDTO: CatDTO): Cat =
        Cat(
            breedName = catDTO.name.orEmpty(),
            baseColor = catDTO.origin.orEmpty(),
            description = catDTO.description.orEmpty(),
            temperament = catDTO.temperament.orEmpty(),
            lifeSpan = catDTO.lifeSpan.orEmpty(),
            origin = catDTO.origin.orEmpty(),
            weight = catDTO.weight?.metric.orEmpty(),
            imageId = catDTO.referenceImageId.orEmpty(),
        )

    fun mapToDomainCats(catDTOs: List<CatDTO>): List<Cat> = catDTOs.map { mapToDomainCat(it) }

    fun mapToDomainCatImage(catImageDTO: CatImageDTO): CatImage =
        CatImage(
            height = catImageDTO.height,
            id = catImageDTO.id,
            url = catImageDTO.url,
            width = catImageDTO.width,
        )
}
