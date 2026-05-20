package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository

class SelectNewsUseCase(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(url: String): Article? {
        return newsRepository.selectNews(url)
    }
}