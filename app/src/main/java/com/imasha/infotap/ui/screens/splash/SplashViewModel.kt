package com.imasha.infotap.ui.screens.splash

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SplashViewModel @Inject constructor() : ViewModel() {

    private val _splashState = MutableLiveData<Result<Boolean>>()
    val splashState: LiveData<Result<Boolean>> get() = _splashState

    fun userAuthentication(duration: Long) {
        viewModelScope.launch {
            try {
                delay(duration)
                _splashState.value = Result.success(true)
            } catch (exception: Exception) {
                _splashState.value = Result.failure(exception)
            }
        }
    }
}