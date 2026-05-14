package com.imasha.infotap.domain.usecases

data class NewsUseCases(
    val getNewsUseCase: GetNewsUseCase,
    val searchNewsUseCase: SearchNewsUseCase,
    val saveNewsUseCase: SaveNewsUseCase,
    val deleteSavedNewsUseCase: DeleteSavedNewsUseCase,
    val getSavedNewsUseCase: GetSavedNewsUseCase,
)