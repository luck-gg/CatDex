package com.luckgg.catdex.domain.usecase

import android.util.Log
import com.luckgg.catdex.common.Resource
import com.luckgg.catdex.domain.model.Cat
import com.luckgg.catdex.domain.repository.CatRepository
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
                Log.d("CatApp", "UseCase: invoke() called")
                val response = catRepository.getCats()
//                emit(response)
                // TODO: This crashes the app
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
