package com.luckgg.presentation.screen

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.luckgg.common.Resource
import com.luckgg.domain.usecase.CatListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class CatListViewModel
    @Inject
    constructor(
        private val catListUseCase: CatListUseCase,
    ) : ViewModel() {
        private val _state = mutableStateOf(CatListState())
        val state: State<CatListState> = _state

        init {
            Log.d("CatApp", "CatListViewModel initialized")
            getCats()
            Log.d("CatApp", "getCats() called and got a cat: ${state.value.cats.size}")
        }

        private fun getCats() {
            catListUseCase()
                .onEach {
                    when (it) {
                        is Resource.Error<*> -> _state.value = CatListState(error = it.message ?: "Un error inesperado ocurrió")
                        is Resource.Loading -> _state.value = CatListState(isLoading = true)
                        is Resource.Success ->
                            _state.value = CatListState(cats = it.data ?: emptyList())
                    }
                }.launchIn(viewModelScope)
        }
    }
