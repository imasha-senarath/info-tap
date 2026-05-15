package com.imasha.infotap.di

import android.app.Application
import androidx.room.Room
import com.imasha.infotap.data.LocalUserMangerImpl
import com.imasha.infotap.data.local.NewsDao
import com.imasha.infotap.data.local.NewsDatabase
import com.imasha.infotap.data.local.NewsTypeConvertor
import com.imasha.infotap.data.remote.NewsApi
import com.imasha.infotap.data.repository.NewsRepositoryImpl
import com.imasha.infotap.domain.manager.LocalUserManager
import com.imasha.infotap.domain.repository.NewsRepository
import com.imasha.infotap.domain.usecases.AppEntryUseCases
import com.imasha.infotap.domain.usecases.DeleteSavedNewsUseCase
import com.imasha.infotap.domain.usecases.GetNewsUseCase
import com.imasha.infotap.domain.usecases.LoginUseCase
import com.imasha.infotap.domain.usecases.NewsUseCases
import com.imasha.infotap.domain.usecases.ReadAppEntry
import com.imasha.infotap.domain.usecases.SaveAppEntry
import com.imasha.infotap.domain.usecases.SaveNewsUseCase
import com.imasha.infotap.domain.usecases.SearchNewsUseCase
import com.imasha.infotap.domain.usecases.GetSavedNewsUseCase
import com.imasha.infotap.domain.usecases.SelectNewsUseCase
import com.imasha.infotap.utils.Constants.BASE_URL
import com.imasha.infotap.utils.Constants.NEWS_DATABASE_NAME
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
        newsRepository: NewsRepository,
        newsDao: NewsDao
    ): NewsUseCases {
        return NewsUseCases(
            getNewsUseCase = GetNewsUseCase(newsRepository),
            searchNewsUseCase = SearchNewsUseCase(newsRepository),
            saveNewsUseCase = SaveNewsUseCase(newsDao),
            deleteSavedNewsUseCase = DeleteSavedNewsUseCase(newsDao),
            getSavedNewsUseCase = GetSavedNewsUseCase(newsDao),
            selectNewsUseCase = SelectNewsUseCase(newsDao),
        )
    }

    @Provides
    @Singleton
    fun provideLoginUseCases(
        newsRepository: NewsRepository
    ): LoginUseCase {
        return LoginUseCase(newsRepository)
    }

    @Provides
    @Singleton
    fun provideNewsDatabase(
        application: Application
    ): NewsDatabase {
        return Room.databaseBuilder(
            context = application,
            klass = NewsDatabase::class.java,
            name = NEWS_DATABASE_NAME
        ).addTypeConverter(NewsTypeConvertor())
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideNewsDao(
        newsDatabase: NewsDatabase
    ): NewsDao = newsDatabase.newsDao
}