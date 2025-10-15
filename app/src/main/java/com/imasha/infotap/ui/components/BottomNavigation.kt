package com.imasha.infotap.ui.components

import androidx.annotation.DrawableRes
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavController

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf("Home", "Saved", "Settings")
    val icons = listOf(Icons.Default.Home, Icons.Default.Star, Icons.Default.Settings)

    NavigationBar {
        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = { Icon(icons[index], contentDescription = item) },
                label = { Text(item) },
                selected = false,
                onClick = {
                    when (item) {
                        "Home" -> navController.navigate("home") {
                            popUpTo("home") { inclusive = true }
                        }
                        "Saved" -> navController.navigate("saved")
                        "Settings" -> navController.navigate("settings")
                    }
                }
            )
        }
    }
}