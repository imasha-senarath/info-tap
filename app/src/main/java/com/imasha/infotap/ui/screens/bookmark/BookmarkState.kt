package com.imasha.infotap.ui.screens.bookmark

import com.imasha.infotap.domain.model.Article

data class BookmarkState (
    val articles: List<Article> = emptyList()
)