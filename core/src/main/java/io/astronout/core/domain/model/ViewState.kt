package io.astronout.core.domain.model

sealed class ViewState {
    data object Loading: ViewState()
    data object Content: ViewState()
    data class Error(val message: String): ViewState()
}