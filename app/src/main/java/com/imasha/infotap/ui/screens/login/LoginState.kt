package com.imasha.infotap.ui.screens.login

sealed class LoginState {
    data object Init : LoginState()
    data object Loading : LoginState()
    data class Success(val message: String) : LoginState()
    data class Error(val message: String) : LoginState()
}