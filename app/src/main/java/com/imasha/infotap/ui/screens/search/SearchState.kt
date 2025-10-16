package com.imasha.infotap.ui.screens.search

import androidx.paging.PagingData
import com.imasha.infotap.domain.model.Article
import kotlinx.coroutines.flow.Flow

data class SearchState(
    val searchQuery: String = "",
    val articles: Flow<PagingData<Article>>? = null
)