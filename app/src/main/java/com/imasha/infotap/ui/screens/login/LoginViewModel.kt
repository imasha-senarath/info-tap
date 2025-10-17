package com.imasha.infotap.ui.screens.login

import androidx.lifecycle.ViewModel
import com.imasha.infotap.domain.usecases.LoginUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
): ViewModel() {

}