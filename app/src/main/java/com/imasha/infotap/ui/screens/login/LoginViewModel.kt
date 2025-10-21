package com.imasha.infotap.ui.screens.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.imasha.infotap.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

    private val _state = MutableStateFlow<LoginState>(LoginState.Init)
    val state: StateFlow<LoginState> = _state

    fun onEvent(event: LoginEvent) {
        when (event) {
            is LoginEvent.Submit -> login(event.email, event.password)
        }
    }

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _state.value = LoginState.Loading

            val result = loginUseCase(email, password)
            result.onSuccess {
                _state.value = LoginState.Success("Login successful")
            }.onFailure { e ->
                _state.value = LoginState.Error(e.message ?: "Unknown error")
            }

        }
    }

    fun resetState() {
        _state.value = LoginState.Init
    }
}