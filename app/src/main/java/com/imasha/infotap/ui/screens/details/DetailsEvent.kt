package com.imasha.infotap.ui.screens.details

import com.imasha.infotap.domain.model.Article

sealed class DetailsEvent {
    data class SaveDeleteArticle(val article: Article) : DetailsEvent()
    data object RemoveSideEffect : DetailsEvent()
}