package com.luckgg.domain.usecase

import com.luckgg.domain.repository.CatRepository
import javax.inject.Inject

class CatListUseCase
    @Inject
    constructor(
        private val catRepository: CatRepository,
    ) {
        operator fun invoke() = catRepository.fetchCats()
    }
