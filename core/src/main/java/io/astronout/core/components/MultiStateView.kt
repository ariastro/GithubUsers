package io.astronout.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import io.astronout.core.domain.model.ViewState

@Composable
fun MultiStateView(
    state: ViewState,
    loadingLayout: @Composable BoxScope.() -> Unit,
    errorLayout: @Composable BoxScope.(String) -> Unit,
    content: @Composable BoxScope.() -> Unit,
    modifier: Modifier = Modifier,
    emptyLayout: @Composable (BoxScope.() -> Unit)? = null,
    idleLayout: @Composable (BoxScope.() -> Unit)? = null,
) {
    Box(modifier = modifier) {
        when (state) {
            is ViewState.Loading -> loadingLayout()
            is ViewState.Error -> errorLayout(state.message)
            is ViewState.Empty -> emptyLayout?.invoke(this)
            is ViewState.Idle -> idleLayout?.invoke(this)
            is ViewState.Content -> content()
        }
    }
}

