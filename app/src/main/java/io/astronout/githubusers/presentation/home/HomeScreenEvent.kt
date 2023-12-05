package io.astronout.githubusers.presentation.home

sealed class HomeScreenEvent {
    data class NavigateToDetailScreen(val username: String): HomeScreenEvent()
    data class OnSearchQueryChange(
        val query: String
    ) : HomeScreenEvent()
    data object ClearSearch: HomeScreenEvent()
}