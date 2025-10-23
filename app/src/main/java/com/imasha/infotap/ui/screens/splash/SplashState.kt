package com.imasha.infotap.ui.screens.splash

sealed class SplashState {
    data object Loading : SplashState()
    data object Navigate : SplashState()
}