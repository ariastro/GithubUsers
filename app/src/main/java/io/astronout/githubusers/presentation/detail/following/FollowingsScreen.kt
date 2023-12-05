package io.astronout.githubusers.presentation.detail.following

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import io.astronout.core.components.MultiStateView
import io.astronout.core.domain.model.UserDetails
import io.astronout.core.domain.model.ViewState
import io.astronout.githubusers.presentation.home.components.UserItem

@Composable
fun FollowingsScreen(
    userDetails: UserDetails,
) {

    MultiStateView(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 20.dp),
        state = ViewState.Content,
        loadingLayout = {},
        errorLayout = {},
        content = {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(vertical = 12.dp),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(items = userDetails.followingList, key = { it.id }) {
                    UserItem(
                        user = it,
                        onEvent = {}
                    )
                }
            }
        }
    )
}