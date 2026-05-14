package com.imasha.infotap.domain.usecases

import com.imasha.infotap.data.local.NewsDao
import com.imasha.infotap.domain.model.Article
import kotlinx.coroutines.flow.Flow

class GetSavedNewsUseCase(
    private val newsDao: NewsDao
) {
    operator fun invoke() : Flow<List<Article>>{
        return newsDao.getArticles()
    }
}