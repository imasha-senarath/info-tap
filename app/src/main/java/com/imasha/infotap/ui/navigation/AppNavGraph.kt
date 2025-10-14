package com.imasha.infotap.ui.navigation

import androidx.compose.runtime.Composable

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.paging.compose.LazyPagingItems
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.ui.screens.home.HomeScreen
import com.imasha.infotap.ui.screens.splash.SplashScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    articles: LazyPagingItems<Article>
) {
    NavHost(navController, startDestination = "splash") {
        composable("splash") { SplashScreen(navController) }
        composable("home") { HomeScreen(navController, articles) }
    }
}