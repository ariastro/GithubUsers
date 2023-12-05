package io.astronout.githubusers.presentation.detail

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Work
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.ramcosta.composedestinations.annotation.Destination
import com.ramcosta.composedestinations.navigation.DestinationsNavigator
import io.astronout.core.components.Gap
import io.astronout.core.components.MultiStateView
import io.astronout.core.components.NetworkImage
import io.astronout.githubusers.R
import io.astronout.githubusers.presentation.detail.components.DetailToolbar
import io.astronout.githubusers.presentation.detail.components.Tabs
import io.astronout.githubusers.ui.theme.Neutral50
import io.astronout.githubusers.ui.theme.Primary70

@Destination
@Composable
fun DetailScreen(
    username: String,
    navigator: DestinationsNavigator,
    viewModel: DetailScreenViewModel = hiltViewModel()
) {

    LaunchedEffect(key1 = true, block = {
        viewModel.onInit(username, navigator)
    })

    val uiState by viewModel.uiState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        DetailToolbar(
            title = username,
            onBackPressed = {
                viewModel.onEvent(DetailScreenEvent.NavigateBack)
            }
        )
        MultiStateView(
            state = uiState.viewState,
            loadingLayout = {},
            errorLayout = {},
            content = {
                uiState.userDetails?.let {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    ) {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            NetworkImage(
                                url = it.avatarUrl,
                                modifier = Modifier
                                    .size(90.dp)
                                    .clip(CircleShape)
                            )
                            Gap(size = 16.dp)
                            Column(
                                modifier = Modifier.weight(1F),
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = it.publicRepos.toString(),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Primary70,
                                )
                                Text(
                                    text = stringResource(R.string.label_repositories),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Neutral50,
                                )
                            }
                            Column(
                                modifier = Modifier.weight(1F),
                                verticalArrangement = Arrangement.spacedBy(8.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = it.followers.toString(),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Primary70,
                                )
                                Text(
                                    text = stringResource(R.string.label_followers),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Neutral50,
                                )
                            }
                            Column(
                                modifier = Modifier.weight(1F),
                                verticalArrangement = Arrangement.spacedBy(4.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            ) {
                                Text(
                                    text = it.following.toString(),
                                    style = MaterialTheme.typography.titleLarge,
                                    color = Primary70,
                                )
                                Text(
                                    text = stringResource(R.string.label_following),
                                    style = MaterialTheme.typography.bodySmall,
                                    color = Neutral50,
                                )
                            }
                        }
                        Text(
                            text = it.name,
                            style = MaterialTheme.typography.titleLarge,
                            color = Primary70,
                            modifier = Modifier.padding(top = 12.dp)
                        )
                        if (it.bio.isNotEmpty()) {
                            Gap(size = 4.dp)
                            Text(
                                text = it.bio,
                                style = MaterialTheme.typography.bodyMedium,
                                color = Neutral50
                            )
                        }
                        if (it.company.isNotEmpty()) {
                            Gap(size = 4.dp)
                            Row(
                                modifier = Modifier.padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.Work,
                                    contentDescription = "",
                                    tint = Neutral50,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = it.company,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Neutral50
                                )
                            }
                        }
                        if (it.location.isNotEmpty()) {
                            Gap(size = 4.dp)
                            Row(
                                modifier = Modifier.padding(top = 4.dp),
                                horizontalArrangement = Arrangement.spacedBy(4.dp),
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Icon(
                                    imageVector = Icons.Default.LocationOn,
                                    contentDescription = "",
                                    tint = Neutral50,
                                    modifier = Modifier.size(16.dp)
                                )
                                Text(
                                    text = it.location,
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Neutral50
                                )
                            }
                        }
                    }
                }
            }
        )
        uiState.userDetails?.let {
            Tabs(
                userDetails = it,
                selectedTabIndex = uiState.selectedTabIndex,
                onTabChanged = viewModel::onEvent
            )
        }
    }
}