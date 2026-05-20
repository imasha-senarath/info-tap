package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository

class SaveNewsUseCase(
    private val newsRepository: NewsRepository
) {
    suspend operator fun invoke(article: Article) {
        newsRepository.saveNews(article)
    }
}