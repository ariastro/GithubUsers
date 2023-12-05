package io.astronout.githubusers.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.ViewState
import io.astronout.core.domain.usecase.SearchUsersUsecase
import io.astronout.core.vo.Resource
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val searchUsersUsecase: SearchUsersUsecase
): ViewModel() {

    private lateinit var navigator: DestinationsNavigator
    private var searchJob: Job? = null

    private val _uiState = MutableStateFlow(HomeUIState())
    val uiState = _uiState.asStateFlow()

    fun onInit(navigator: DestinationsNavigator) {
        this.navigator = navigator
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.NavigateToDetailScreen -> navigateToDetailScreen(event.username)
            is HomeScreenEvent.OnSearchQueryChange -> onSearchQueryChanged(event.query)
            is HomeScreenEvent.ClearSearch -> clearSearch()
        }
    }

    private fun onSearchQueryChanged(query: String) {
        _uiState.update {
            it.copy(query = query)
        }
        searchJob?.cancel()
        searchJob = viewModelScope.launch {
            delay(500L)
            if (query.isNotEmpty()) {
                searchGames(query)
            } else {
                clearSearch()
            }
        }
    }

    private fun searchGames(query: String) {
        searchUsersUsecase.invoke(query).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update {
                        it.copy(state = ViewState.Error(result.message))
                    }
                }
                is Resource.Loading -> {
                    _uiState.update {
                        it.copy(state = ViewState.Loading)
                    }
                }
                is Resource.Success -> {
                    _uiState.update {
                        it.copy(users = result.data, state = ViewState.Content)
                    }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun clearSearch() {
        _uiState.update {
            it.copy(users = emptyList(), state = ViewState.Content)
        }
    }

    private fun navigateToDetailScreen(username: String) {

    }

}