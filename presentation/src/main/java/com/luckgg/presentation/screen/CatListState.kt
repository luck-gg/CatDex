package com.luckgg.presentation.screen

import com.luckgg.domain.model.Cat

data class CatListState(
    val isLoading: Boolean = false,
    val cats: List<Cat> = emptyList(),
    val error: String = "",
)
