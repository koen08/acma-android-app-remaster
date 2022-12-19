package com.userstory.presentation.base.view_model

import androidx.lifecycle.ViewModel
import com.userstory.presentation.model.UiEvent
import com.userstory.presentation.model.UiState
import com.userstory.presentation.model.uiEvent.MessageEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.*

abstract class BaseViewModel<UiStateModel : UiState, UiEventModel: UiEvent> : ViewModel() {
    /**
     * Состояние UI данной View
     * */
    protected abstract val _uiState: MutableStateFlow<out UiStateModel>
    abstract val uiState: StateFlow<UiStateModel>

    /**
     * UI события, которые вызываются один раз (single fire) без сохранения состояния
     * */
    protected open val _uiEvent: Channel<out UiEventModel> = Channel()
    open val uiEvent: Flow<UiEventModel> by lazy { _uiEvent.receiveAsFlow() }

    /**
     * UI оповещения, которые вызываются один раз (single fire) без сохранения состояния
     * */
    protected val _uiMessageEvent = Channel<MessageEvent>()
    val uiMessageEvent = _uiMessageEvent.receiveAsFlow()
}