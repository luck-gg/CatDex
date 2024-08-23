package com.luckgg.catdex.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luckgg.catdex.presentation.screen.components.CatItem

@Suppress("ktlint:compose:modifier-missing-check", "ktlint:standard:function-naming")
@Composable
fun CatListScreen(
    navController: NavController,
    viewModel: CatListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    when {
        state.error.isNotBlank() -> {
            // Mostrar un mensaje de error
        }
        state.isLoading -> {
            // Mostrar un indicador de carga
        }
        state.cats.isNotEmpty() -> {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(state.cats) { cat ->
                        CatItem(cat)
                    }
                }
            }
        }
    }
}
