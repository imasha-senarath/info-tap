package com.imasha.infotap.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.imasha.infotap.data.local.NewsDao
import com.imasha.infotap.data.remote.NewsApi
import com.imasha.infotap.data.remote.NewsPagingSource
import com.imasha.infotap.data.remote.SearchNewsPagingSource
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.repository.NewsRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow

class NewsRepositoryImpl(
    private val newsApi: NewsApi,
    private val newsDao: NewsDao
): NewsRepository {

    override fun getNews(sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                NewsPagingSource(newsApi = newsApi, sources = sources.joinToString(separator = ","))
            }
        ).flow
    }

    override fun searchNews(searchQuery: String, sources: List<String>): Flow<PagingData<Article>> {
        return Pager(
            config = PagingConfig(pageSize = 10),
            pagingSourceFactory = {
                SearchNewsPagingSource(
                    newsApi = newsApi,
                    searchQuery = searchQuery,
                    sources = sources.joinToString(separator = ",")
                )
            }
        ).flow
    }

    override suspend fun saveNews(article: Article) {
        newsDao.saveArticles(article)
    }

    override suspend fun deleteNews(article: Article) {
        newsDao.delete(article)
    }

    override fun getSavedNews(): Flow<List<Article>> {
        return newsDao.getArticles()
    }

    override suspend fun selectNews(url: String): Article? {
        return newsDao.getArticle(url)
    }

    /*override fun login(email: String, password: String): Flow<Result<Boolean>> = flow {
        if(email == "imasha@gmail.com" && password == "123456") {
            emit(Result.success(true))
        } else {
            emit(Result.failure(Exception("Invalid credentials")))
        }
    }*/

    /*override suspend fun login(email: String, password: String): Boolean {
        delay(2000)
        return email == "imasha@gmail.com" && password == "1234"
    }*/

    override suspend fun login(email: String, password: String): Result<Boolean> {
        delay(2000) // server simulation

        return try {
            if(email == "imasha@gmail.com" && password == "1234") Result.success(true)
            else Result.failure(Exception("Invalid credentials"))
        } catch (e: Exception) {
            Result.failure(Exception("Login failed: ${e.message}"))
        }
    }
}