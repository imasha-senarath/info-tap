package com.imasha.infotap.domain.repository

import androidx.paging.PagingData
import com.imasha.infotap.domain.model.Article
import kotlinx.coroutines.flow.Flow

interface NewsRepository {

    fun getNews(sources: List<String>): Flow<PagingData<Article>>

    fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>>

    suspend fun saveNews(article: Article)

    suspend fun deleteNews(article: Article)

    fun getSavedNews(): Flow<List<Article>>

    suspend fun selectNews(url: String): Article?

    //fun login(username: String, password: String): Flow<Result<Boolean>>

    suspend fun login(email: String, password: String): Result<Boolean>
}