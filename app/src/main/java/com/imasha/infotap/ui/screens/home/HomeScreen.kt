package com.imasha.infotap.ui.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.basicMarquee
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.paging.compose.collectAsLazyPagingItems
import com.imasha.infotap.R
import com.imasha.infotap.ui.components.ArticlesList
import com.imasha.infotap.ui.components.BottomNavigation
import com.imasha.infotap.ui.components.SearchBar
import com.imasha.infotap.utils.Dimens.MediumPadding1

@Composable
fun HomeScreen(
    navController: NavController,
    viewModel: HomeViewModel = hiltViewModel(),
) {
    val articles = viewModel.news.collectAsLazyPagingItems()

    val titles by remember {
        derivedStateOf {
            if (articles.itemCount > 10) {
                articles.itemSnapshotList.items
                    .slice(IntRange(start = 0, endInclusive = 9))
                    .joinToString(separator = " \uD83D\uDFE5 ") { it.title }
            } else {
                ""
            }
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavigation(navController)
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(top = MediumPadding1)
                .statusBarsPadding()
        ) {

            Row(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = R.drawable.ic_logo),
                    contentDescription = null,
                    modifier = Modifier
                        .width(40.dp)
                        .height(40.dp)
                )
                Text(
                    text = "Home", modifier = Modifier
                        .fillMaxWidth()
                        .basicMarquee(), fontSize = 22.sp,
                )
            }

            Spacer(modifier = Modifier.height(MediumPadding1))

            SearchBar(
                modifier = Modifier
                    .padding(horizontal = MediumPadding1)
                    .fillMaxWidth(),
                text = "",
                readOnly = true,
                onValueChange = {},
                onSearch = {},
                onClick = {
                    //navigate(Route.SearchScreen.route)
                }
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            Text(
                text = titles, modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = MediumPadding1)
                    .basicMarquee(), fontSize = 12.sp,
                color = colorResource(id = R.color.placeholder)
            )

            Spacer(modifier = Modifier.height(MediumPadding1))

            ArticlesList(
                modifier = Modifier.padding(horizontal = MediumPadding1),
                articles = articles,
                onClick = {
                    //TODO: Navigate to Details Screen
                }
            )
        }
    }
}