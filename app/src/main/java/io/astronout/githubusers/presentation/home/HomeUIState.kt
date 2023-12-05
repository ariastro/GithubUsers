package io.astronout.githubusers.presentation.home

import io.astronout.core.domain.model.User
import io.astronout.core.domain.model.ViewState

data class HomeUIState(
    val users: List<User> = emptyList(),
    val query: String = "",
    val state: ViewState = ViewState.Content
)