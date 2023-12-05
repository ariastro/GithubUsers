package io.astronout.githubusers.presentation.detail

import io.astronout.core.domain.model.UserDetails
import io.astronout.core.domain.model.ViewState

data class DetailScreenUIState(
    val userDetails: UserDetails? = null,
    val viewState: ViewState = ViewState.Content,
    val selectedTabIndex: Int = 0
)