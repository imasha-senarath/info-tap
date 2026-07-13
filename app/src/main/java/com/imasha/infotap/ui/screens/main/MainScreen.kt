package com.imasha.infotap.ui.screens.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.ui.components.BottomNavigation
import com.imasha.infotap.ui.navigation.Routes
import com.imasha.infotap.ui.screens.bookmark.BookmarkScreen
import com.imasha.infotap.ui.screens.bookmark.BookmarkViewModel
import com.imasha.infotap.ui.screens.home.HomeScreen
import com.imasha.infotap.ui.screens.search.SearchScreen
import com.imasha.infotap.ui.screens.search.SearchViewModel

@Composable
fun MainScreen(
    mainNavController: NavController,
) {
    val bottomNavController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(bottomNavController)
        }
    ) { innerPadding ->
        NavHost(
            navController = bottomNavController,
            startDestination = Routes.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HomeScreen.route) {
                HomeScreen(
                    bottomNavController,
                    navigateToDetails = { article ->
                        navigateToDetailsScreen(
                            navController = mainNavController,
                            article = article
                        )
                    }
                )
            }

            composable(Routes.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(
                    viewModel.state.value,
                    event = viewModel::onEvent,
                    navigateToDetails = { article ->
                        navigateToDetailsScreen(
                            navController = mainNavController,
                            article = article
                        )
                    })
            }

            composable(Routes.BookmarkScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(
                    state = viewModel.state.value,
                    navigateToDetails = { article ->
                        navigateToDetailsScreen(
                            navController = mainNavController,
                            article = article
                        )
                    }
                )
            }
        }
    }
}

private fun navigateToDetailsScreen(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Routes.DetailsScreen.route
    )
}