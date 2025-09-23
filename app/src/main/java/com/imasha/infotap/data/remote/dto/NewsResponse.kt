package com.imasha.infotap.data.remote.dto

import com.imasha.infotap.domain.model.Article

data class NewsResponse(
    val articles: List<Article>,
    val status: String,
    val totalResults: Int
)