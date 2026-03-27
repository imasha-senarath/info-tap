package com.imasha.infotap.ui.screens.details

sealed class DetailsEvent {
    data object SaveArticle : DetailsEvent()
}