package com.userstory.presentation.fragments.auth.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.userstory.domain.usecase.login.LoginUseCase
import com.userstory.presentation.base.view_model.BaseViewModel
import com.userstory.presentation.model.UiEvent
import com.userstory.presentation.model.uiEvent.MessageEvent
import com.userstory.presentation.model.uiState.auth.login.LoginUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor (
    private val loginUseCase: LoginUseCase
) : BaseViewModel<LoginUiState, UiEvent>(){
    override val _uiState: MutableStateFlow<out LoginUiState>
        get() = TODO("Not yet implemented")
    override val uiState: StateFlow<LoginUiState>
        get() = TODO("Not yet implemented")


    fun getLogin() : String {
        return loginUseCase.invoke(10)
    }


}