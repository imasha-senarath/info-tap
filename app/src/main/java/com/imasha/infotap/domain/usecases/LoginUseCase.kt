package com.imasha.infotap.domain.usecases

import com.imasha.infotap.domain.repository.NewsRepository

class LoginUseCase(private val newsRepository: NewsRepository) {
  /*  operator fun invoke(email: String, password: String) =
        newsRepository.login(email, password)*/

    suspend operator fun invoke(email: String, password: String): Result<Boolean> {
        if (email.isBlank() || password.isBlank()) {
            return Result.failure(Exception("Fields cannot be empty"))
        }

        try {
            val result = newsRepository.login(email, password)
            return if (result) Result.success(true)
            else Result.failure(Exception("Invalid credentials"))
        } catch (e: Exception) {
            return Result.failure(Exception("Login failed: ${e.message}"))
        }
    }
}