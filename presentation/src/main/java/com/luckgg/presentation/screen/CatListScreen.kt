package com.luckgg.presentation.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.LoadState
import androidx.paging.compose.collectAsLazyPagingItems
import androidx.paging.compose.itemContentType
import androidx.paging.compose.itemKey
import com.luckgg.presentation.screen.components.CatItem

@Suppress("ktlint:standard:function-naming")
@Composable
fun CatListScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    viewModel: CatListViewModel = hiltViewModel(),
) {
    val catPager = viewModel.catPager.collectAsLazyPagingItems()
    Column(modifier = Modifier.fillMaxSize()) {
        LazyColumn(
            state = rememberLazyListState(),
        ) {
            items(
                count = catPager.itemCount,
                key = catPager.itemKey(),
                contentType = catPager.itemContentType(),
            ) { index ->
                catPager[index]?.let { cat ->
                    CatItem(catItem = cat)
                }
                HorizontalDivider()
            }
            when (catPager.loadState.refresh) {
                is LoadState.Error -> Unit
                LoadState.Loading -> {
                    item {
                        Column(
                            modifier =
                                Modifier
                                    .fillParentMaxSize(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(
                                modifier =
                                    Modifier
                                        .padding(8.dp),
                                text = "Loading Cat List",
                            )

                            CircularProgressIndicator()
                        }
                    }
                }
                else -> Unit
            }
            when (catPager.loadState.append) {
                is LoadState.Error -> Unit
                LoadState.Loading -> {
                    item {
                        Column(
                            modifier =
                                Modifier
                                    .fillMaxWidth(),
                            horizontalAlignment = Alignment.CenterHorizontally,
                            verticalArrangement = Arrangement.Center,
                        ) {
                            Text(text = "Pagination Loading")

                            CircularProgressIndicator()
                        }
                    }
                }
                else -> Unit
            }
        }
    }
}
