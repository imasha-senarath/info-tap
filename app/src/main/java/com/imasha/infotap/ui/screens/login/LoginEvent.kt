package com.imasha.infotap.ui.screens.login

sealed class LoginEvent {
    data class Submit(val email: String, val password: String) : LoginEvent()
}