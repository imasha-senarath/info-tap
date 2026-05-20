package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(
    private val newsRepository: NewsRepository
) {
    operator fun invoke() : Flow<List<Article>>{
        return newsRepository.getSavedNews()
    }
}