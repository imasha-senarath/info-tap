package com.imasha.infotap.ui.screens.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.cachedIn
import com.imasha.infotap.domain.usecases.GetNewsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    getNewsUseCase: GetNewsUseCase
): ViewModel() {
    val news = getNewsUseCase(
        sources = listOf("bbc-news", "abc-news")
    ).cachedIn(viewModelScope)
}