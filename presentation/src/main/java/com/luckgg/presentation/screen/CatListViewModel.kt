package com.luckgg.presentation.screen

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import com.luckgg.domain.model.Cat
import com.luckgg.domain.usecase.CatListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class CatListViewModel
    @Inject
    constructor(
        catListUseCase: CatListUseCase,
    ) : ViewModel() {
        val catPager: Flow<PagingData<Cat>> = catListUseCase()
    }
