package com.luckgg.presentation

sealed class Screen(
    val route: String,
) {
    data object CatListScreen : Screen("cat_list_screen")
}
