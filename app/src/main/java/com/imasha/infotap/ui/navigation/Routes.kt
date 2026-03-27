package com.imasha.infotap.ui.navigation

sealed class Routes(val route: String) {
    data object SplashScreen : Routes(route = "splashScreen")

    data object LoginScreen : Routes(route = "loginScreen")

    data object MainScreen : Routes(route = "mainScreen")

    data object HomeScreen : Routes(route = "homeScreen")

    data object SearchScreen : Routes(route = "searchScreen")

    data object DetailsScreen : Routes(route = "detailsScreen")

    data object SavedScreen : Routes(route = "savedScreen")

    data object SettingScreen : Routes(route = "settingScreen")
}