package io.astronout.githubusers.presentation.detail

sealed class DetailScreenEvent {
    data object NavigateBack: DetailScreenEvent()
    data class ActiveTabIndex(val index: Int): DetailScreenEvent()
}