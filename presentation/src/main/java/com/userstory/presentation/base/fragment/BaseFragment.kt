package com.userstory.presentation.base.fragment

import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import com.userstory.presentation.base.view_model.BaseViewModel
import com.userstory.presentation.model.UiEvent
import com.userstory.presentation.model.UiState

abstract class BaseFragment<
        UiStateModel : UiState,
        UiEventModel : UiEvent,
        ViewModel : BaseViewModel<UiStateModel, UiEventModel>,
        ViewBinding : androidx.viewbinding.ViewBinding>(@LayoutRes contentLayoutId: Int) :
    Fragment(contentLayoutId) {
    abstract val binding: ViewBinding

    fun handleUiState(uiState: UiStateModel) = Unit
    fun handleUiEvent(uiEvent: UiStateModel) = Unit
}