package com.imasha.infotap.domain.usecases.news

import androidx.paging.PagingData
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetNews(
    private val newsRepository: NewsRepository
) {
    operator fun invoke(sources: List<String>): Flow<PagingData<Article>> {
        return newsRepository.getNews(sources = sources)
    }
}