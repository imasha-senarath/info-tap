package com.imasha.infotap.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.imasha.infotap.ui.navigation.Routes

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(Routes.HomeScreen.route, Routes.SavedScreen.route, Routes.SettingScreen.route)
    val icons = listOf(Icons.Default.Home, Icons.Default.Star, Icons.Default.Settings)

    NavigationBar (
        modifier = Modifier.height(60.dp)
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = currentRoute == item,
                onClick = {
                    navController.navigate(item) {
                        popUpTo(Routes.HomeScreen.route)
                        launchSingleTop = true
                    }
                    /*when (item) {
                        "Home" -> navController.navigate(Routes.HomeScreen.route) {
                            popUpTo(Routes.HomeScreen.route) { inclusive = true }
                        }
                        "Saved" -> navController.navigate(Routes.SavedScreen.route) {
                            popUpTo(Routes.HomeScreen.route) { inclusive = true }
                        }
                        "Settings" -> navController.navigate(Routes.SettingScreen.route) {
                            popUpTo(Routes.HomeScreen.route) { inclusive = true }
                        }
                    }*/
                }
            )
        }
    }
}