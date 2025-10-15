package com.imasha.infotap.ui.navigation

sealed class Routes(val route: String) {
    data object SplashScreen : Routes(route = "splashScreen")

    data object LoginScreen : Routes(route = "loginScreen")

    data object HomeScreen : Routes(route = "homeScreen")
}