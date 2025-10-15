package com.imasha.infotap.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.imasha.infotap.domain.usecases.NewsUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    newsUseCases: NewsUseCases
): ViewModel() {
    val news = newsUseCases.getNews(
        sources = listOf("bbc-news", "abc-news")
    ).cachedIn(viewModelScope)
}