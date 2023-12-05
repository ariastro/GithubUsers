package io.astronout.githubusers.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.annotation.RootNavGraph
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.components.MultiStateView
import io.astronout.core.domain.model.ViewState
import io.astronout.core.utils.showToast
import io.astronout.githubusers.R
import io.astronout.githubusers.presentation.home.components.SearchField
import io.astronout.githubusers.presentation.home.components.UserItem
import io.astronout.githubusers.ui.theme.Neutral10
import io.astronout.githubusers.ui.theme.Neutral40
import io.astronout.githubusers.ui.theme.Neutral50
import io.astronout.githubusers.ui.theme.Primary50

@RootNavGraph(true)
@Destination
@Composable
fun HomeScreen(
    navigator: DestinationsNavigator,
    viewModel: HomeViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.onInit(navigator)
    })

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(horizontal = 24.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 24.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Image(
                painter = painterResource(id = R.drawable.ic_github_logo),
                contentDescription = null,
                colorFilter = ColorFilter.tint(Primary50),
                modifier = Modifier.size(56.dp)
            )
            Column(
                modifier = Modifier.weight(1F),
            ) {
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.titleLarge,
                    color = Primary50,
                )
                Text(
                    text = "Github User Finder",
                    style = MaterialTheme.typography.bodyLarge,
                    color = Neutral50,
                )
            }
        }
        SearchField(
            query = uiState.query,
            onEvent = viewModel::onEvent,
            modifier = Modifier.padding(top = 24.dp)
        )
        MultiStateView(
            modifier = Modifier.fillMaxSize().padding(top = 12.dp),
            state = uiState.state,
            loadingLayout = {
                Text(text = "Loading")
            },
            errorLayout = {

            },
            content = {
                LazyColumn(
                    modifier = Modifier.fillMaxSize(),
                    contentPadding = PaddingValues(vertical = 12.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    items(items = uiState.users, key = { it.id }) {
                        UserItem(
                            user = it,
                            onEvent = { user ->
                                viewModel.onEvent(HomeScreenEvent.NavigateToDetailScreen(user.login))
                            }
                        )
                    }
                }
            },
        )
    }
}