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
import com.imasha.infotap.ui.screens.details.DetailsScreen
import com.imasha.infotap.ui.screens.details.DetailsViewModel
import com.imasha.infotap.ui.screens.home.HomeScreen
import com.imasha.infotap.ui.screens.search.SearchScreen
import com.imasha.infotap.ui.screens.search.SearchViewModel

@Composable
fun MainScreen(
    //navController: NavController,
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Routes.HomeScreen.route,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(Routes.HomeScreen.route) {
                HomeScreen(
                    navController,
                    navigateToDetails = { article ->
                        navigateToDetails(
                            navController = navController,
                            article = article
                        )
                    })
            }

            composable(Routes.SavedScreen.route) {
                val viewModel: BookmarkViewModel = hiltViewModel()
                BookmarkScreen(state = viewModel.state.value, navigateToDetails = {})
            }

            composable(route = Routes.DetailsScreen.route) {
                val viewModel: DetailsViewModel = hiltViewModel()
                navController.previousBackStackEntry?.savedStateHandle?.get<Article?>("article")
                    ?.let { article ->
                        DetailsScreen(
                            article = article,
                            event = viewModel::onEvent,
                            navigateUp = { navController.navigateUp() }
                        )
                    }

            }

            composable(Routes.SearchScreen.route) {
                val viewModel: SearchViewModel = hiltViewModel()
                SearchScreen(viewModel.state.value, event = viewModel::onEvent)
            }
        }
    }
}

private fun navigateToDetails(navController: NavController, article: Article) {
    navController.currentBackStackEntry?.savedStateHandle?.set("article", article)
    navController.navigate(
        route = Routes.DetailsScreen.route
    )
}