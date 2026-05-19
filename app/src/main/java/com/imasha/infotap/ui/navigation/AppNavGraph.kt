package com.imasha.infotap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.ui.screens.details.DetailsScreen
import com.imasha.infotap.ui.screens.details.DetailsViewModel
import com.imasha.infotap.ui.screens.main.MainScreen
import com.imasha.infotap.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.SplashScreen.route
    ) {

        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(Routes.MainScreen.route) {
            MainScreen(mainNavController = navController)
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
    }
}