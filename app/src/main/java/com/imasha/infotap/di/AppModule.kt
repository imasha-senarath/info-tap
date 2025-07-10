package com.imasha.infotap.di

import android.app.Application
import com.imasha.infotap.data.LocalUserMangerImpl
import com.imasha.infotap.domain.manager.LocalUserManager
import com.imasha.infotap.domain.usecases.AppEntryUseCases
import com.imasha.infotap.domain.usecases.ReadAppEntry
import com.imasha.infotap.domain.usecases.SaveAppEntry
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
}