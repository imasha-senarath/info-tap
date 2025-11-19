package com.imasha.infotap.ui.screens.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.imasha.infotap.ui.components.BottomNavigation
import com.imasha.infotap.ui.navigation.Routes
import com.imasha.infotap.ui.screens.home.HomeScreen
import com.imasha.infotap.ui.screens.saved.SavedScreen
import com.imasha.infotap.ui.screens.setting.SettingScreen

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
        Box(modifier = Modifier.padding(innerPadding)) {
            NavHost(
                navController = navController,
                startDestination = Routes.HomeScreen.route,
                modifier = Modifier.padding(innerPadding)
            ) {

                composable(Routes.HomeScreen.route) {
                    HomeScreen(navController)
                }

                composable(Routes.SavedScreen.route) {
                    SavedScreen(navController)
                }

                composable(Routes.SettingScreen.route) {
                    SettingScreen(navController)
                }
            }
        }
    }
}