package com.luckgg.catdex.presentation

sealed class Screen(
    val route: String,
) {
    data object CatListScreen : Screen("cat_list_screen")
}
