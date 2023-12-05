package io.astronout.githubusers.presentation.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import dagger.hilt.android.lifecycle.HiltViewModel
import io.astronout.core.domain.model.ViewState
import io.astronout.core.domain.usecase.UserDetailUsecase
import io.astronout.core.vo.Resource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class DetailScreenViewModel @Inject constructor(
    private val userDetailUsecase: UserDetailUsecase
): ViewModel() {

    private lateinit var navigator: DestinationsNavigator

    private val _uiState = MutableStateFlow(DetailScreenUIState())
    val uiState = _uiState.asStateFlow()

    fun onInit(username: String, navigator: DestinationsNavigator) {
        this.navigator = navigator
        getUserDetails(username)
    }

    fun onEvent(event: DetailScreenEvent) {
        when (event) {
            is DetailScreenEvent.ActiveTabIndex -> setActiveTabIndex(event.index)
            is DetailScreenEvent.NavigateBack -> navigateBack()
        }
    }

    private fun getUserDetails(username: String) {
        userDetailUsecase.invoke(username).onEach { result ->
            when (result) {
                is Resource.Error -> {
                    _uiState.update { it.copy(userDetailsState = ViewState.Error(result.message)) }
                }
                is Resource.Loading -> {
                    _uiState.update { it.copy(userDetailsState = ViewState.Loading) }
                }
                is Resource.Success -> {
                    _uiState.update { it.copy(userDetails = result.data, userDetailsState = ViewState.Content) }
                }
            }
        }.launchIn(viewModelScope)
    }

    private fun setActiveTabIndex(index: Int) {
        _uiState.update {
            it.copy(selectedTabIndex = index)
        }
    }

    private fun navigateBack() {
        navigator.popBackStack()
    }

}