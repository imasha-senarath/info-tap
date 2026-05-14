package com.imasha.infotap.domain.usecases

import com.imasha.infotap.data.local.NewsDao
import com.imasha.infotap.domain.model.Article

class DeleteSavedNewsUseCase(
    private val newsDao: NewsDao
) {
    suspend operator fun invoke(article: Article){
        newsDao.delete(article = article)
    }
}