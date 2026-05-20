package com.imasha.infotap.ui.screens.details

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imasha.infotap.domain.model.Article
import com.imasha.infotap.domain.usecases.DeleteSavedNewsUseCase
import com.imasha.infotap.domain.usecases.SaveNewsUseCase
import com.imasha.infotap.domain.usecases.SelectNewsUseCase
import com.imasha.infotap.utils.UIComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val selectNewsUseCase: SelectNewsUseCase,
    private val saveNewsUseCase: SaveNewsUseCase,
    private val deleteSavedNewsUseCase: DeleteSavedNewsUseCase
): ViewModel() {

    var sideEffect by mutableStateOf<UIComponent?>(null)
        private set

    fun onEvent(event: DetailsEvent) {
        when (event) {
            is DetailsEvent.SaveDeleteArticle -> {
                viewModelScope.launch {
                    val article = selectNewsUseCase(event.article.url)
                    if (article == null){
                        saveArticle(article = event.article)
                    }else{
                        deleteArticle(article = event.article)
                    }
                }
            }

            is DetailsEvent.RemoveSideEffect ->{
                sideEffect = null
            }
        }
    }

    private suspend fun saveArticle(article: Article) {
        saveNewsUseCase(article = article)
        sideEffect = UIComponent.Toast("Article inserted.")
    }

    private suspend fun deleteArticle(article: Article) {
        deleteSavedNewsUseCase(article = article)
        sideEffect = UIComponent.Toast("Article deleted.")
    }
}