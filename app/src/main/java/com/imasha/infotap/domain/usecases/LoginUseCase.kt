package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.repository.NewsRepository

class LoginUseCase(private val newsRepository: NewsRepository) {

    suspend operator fun invoke(email: String, password: String): Result<Boolean> {
        return if (email.isBlank() || password.isBlank()) {
            Result.failure(Exception("Fields cannot be empty"))
        } else {
            newsRepository.login(email, password)
        }
    }
}