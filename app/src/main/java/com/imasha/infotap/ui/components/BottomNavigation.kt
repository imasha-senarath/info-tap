package com.imasha.infotap.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.imasha.infotap.R
import com.imasha.infotap.ui.navigation.Routes

@Composable
fun BottomNavigation(navController: NavController) {
    val items = listOf(Routes.HomeScreen.route, Routes.SearchScreen.route, Routes.BookmarkScreen.route)
    val titles = listOf("Home", "Search", "Bookmark")
    val icons = listOf(R.drawable.ic_home, R.drawable.ic_search, R.drawable.ic_bookmark)

    NavigationBar(
        modifier = Modifier.height(60.dp)
    ) {
        val currentRoute = navController.currentBackStackEntry?.destination?.route

        items.forEachIndexed { index, item ->
            NavigationBarItem(
                icon = {
                    Icon(
                        painter = painterResource(id = icons[index]),
                        contentDescription = item
                    )
                },
                label = { Text(titles[index]) },
                selected = currentRoute == item,
                onClick = {
                    navController.navigate(item) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                }
            )
        }
    }
}