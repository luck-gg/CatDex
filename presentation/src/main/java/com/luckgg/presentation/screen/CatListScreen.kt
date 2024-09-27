package com.luckgg.presentation.screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.luckgg.common.R
import com.luckgg.presentation.screen.components.CatItem

@Composable
fun CatListScreen(
    navController: NavController,
    viewModel: CatListViewModel = hiltViewModel(),
) {
    val state = viewModel.state.value
    when {
        state.error.isNotBlank() -> {
            Text(text = stringResource(R.string.cat_list_error_title, state.error))
        }
        state.isLoading -> {
            CircularProgressIndicator()
        }
        state.cats.isNotEmpty() -> {
            Box(modifier = Modifier.fillMaxSize()) {
                LazyColumn {
                    items(state.cats) { cat ->
                        CatItem(catItem = cat)
                    }
                }
            }
        }
    }
}