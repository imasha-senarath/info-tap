package com.imasha.infotap.di

import android.app.Application
import com.imasha.infotap.data.LocalUserMangerImpl
import com.imasha.infotap.data.remote.NewsApi
import com.imasha.infotap.data.repository.NewsRepositoryImpl
import com.imasha.infotap.domain.manager.LocalUserManager
import com.imasha.infotap.domain.repository.NewsRepository
import com.imasha.infotap.domain.usecases.AppEntryUseCases
import com.imasha.infotap.domain.usecases.GetNews
import com.imasha.infotap.domain.usecases.NewsUseCases
import com.imasha.infotap.domain.usecases.ReadAppEntry
import com.imasha.infotap.domain.usecases.SaveAppEntry
import com.imasha.infotap.domain.usecases.SearchNews
import com.imasha.infotap.utils.Constants.BASE_URL
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideLocalUserManger(
        application: Application
    ): LocalUserManager = LocalUserMangerImpl(context = application)

    @Provides
    @Singleton
    fun provideAppEntryUseCases(
        localUserManger: LocalUserManager
    ): AppEntryUseCases = AppEntryUseCases(
        readAppEntry = ReadAppEntry(localUserManger),
        saveAppEntry = SaveAppEntry(localUserManger)
    )

    @Provides
    @Singleton
    fun provideApiInstance(): NewsApi {
        return Retrofit
            .Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(NewsApi::class.java)
    }

    @Provides
    @Singleton
    fun provideNewsRepository(
        newsApi: NewsApi
    ): NewsRepository {
        return NewsRepositoryImpl(newsApi)
    }

    @Provides
    @Singleton
    fun provideNewsUseCases(
        newsRepository: NewsRepository
    ): NewsUseCases {
        return NewsUseCases(
            getNews = GetNews(newsRepository),
            searchNews = SearchNews(newsRepository)
        )
    }
}