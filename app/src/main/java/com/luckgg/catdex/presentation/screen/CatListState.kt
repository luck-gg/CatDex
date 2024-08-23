package com.luckgg.catdex.presentation.screen

import com.luckgg.catdex.domain.model.Cat

data class CatListState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val error: String = "",
)
