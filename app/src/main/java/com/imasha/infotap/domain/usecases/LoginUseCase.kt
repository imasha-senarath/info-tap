package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.repository.NewsRepository

class LoginUseCase(private val newsRepository: NewsRepository) {
    operator fun invoke(username: String, password: String) =
        newsRepository.login(username, password)
}