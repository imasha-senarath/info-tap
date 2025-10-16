package com.imasha.infotap.domain.usecases

import androidx.paging.PagingData
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class SearchNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.searchNews(
            searchQuery = searchQuery,
            sources = sources
        )
    }
}