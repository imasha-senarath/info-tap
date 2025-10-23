package com.imasha.infotap.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imasha.infotap.ui.screens.home.HomeScreen
import com.imasha.infotap.ui.screens.login.LoginScreen
import com.imasha.infotap.ui.screens.search.SearchScreen
import com.imasha.infotap.ui.screens.search.SearchViewModel
import com.imasha.infotap.ui.screens.splash.SplashScreen

@Composable
fun NavGraph() {
    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Routes.SplashScreen.route) {

        composable(Routes.SplashScreen.route) {
            SplashScreen(navController)
        }

        composable(Routes.LoginScreen.route) {
            LoginScreen(navController)
        }

        composable(Routes.HomeScreen.route) {
            HomeScreen(navController)
        }

        composable(Routes.SearchScreen.route) {
            val viewModel: SearchViewModel = hiltViewModel()
            SearchScreen (viewModel.state.value) {}
        }

        /*navigation(
            route = Route.AppStartNavigation.route,
            startDestination = Route.OnBoardingScreen.route
        ) {
            composable(route = Route.OnBoardingScreen.route) {
                val viewModel: OnBoardingViewModel = hiltViewModel()
                OnBoardingScreen(event = viewModel::onEvent)
            }
        }

        navigation(
            route = Route.NewsNavigation.route,
            startDestination = Route.NewsNavigatorScreen.route
        ) {
            composable(route = Route.NewsNavigatorScreen.route) {
                Text(text = "News Navigator Screen")
            }
        }*/
    }
}