package com.imasha.infotap.domain.repository

import androidx.paging.PagingData
import com.imasha.infotap.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    fun login(username: String, password: String): Flow<Result<Boolean>>
}