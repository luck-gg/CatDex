package com.luckgg.domain.usecase

import com.luckgg.common.Resource
import com.luckgg.domain.model.Cat
import com.luckgg.domain.repository.CatRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class CatListUseCase
    @Inject
    constructor(
        private val catRepository: CatRepository,
    ) {
        operator fun invoke(): Flow<Resource<List<Cat>>> =
            flow {
                emit(Resource.Loading())
                val response = catRepository.fetchCats()
                emit(response)
            }.catch { e ->
                emit(Resource.Error(e.localizedMessage ?: "An unexpected error occurred"))
            }
    }
