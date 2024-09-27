package com.luckgg.catdex.domain.usecase

import com.luckgg.catdex.domain.repository.CatRepository
import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatListUseCase
    @Inject
    constructor(
        private val catRepository: CatRepository,
    ) {
        operator fun invoke(): Flow<Resource<List<Cat>>> =
            flow {
                val response = catRepository.getCats()
                response.data?.let { catList ->
                    val updatedCatList =
                        catList.map { cat ->
                            val imageUrl =
                                catRepository
                                    .getCatImage(cat.imageId)
                                    .data
                                    ?.url
                                    .orEmpty()
                            cat.copy(imageUrl = imageUrl)
                        }
                    emit(Resource.Success(updatedCatList))
                }
            }
    }
