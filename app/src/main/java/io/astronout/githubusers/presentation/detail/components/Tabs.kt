package io.astronout.githubusers.presentation.detail.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import io.astronout.core.domain.model.UserDetails
import io.astronout.githubusers.R
import io.astronout.githubusers.presentation.detail.DetailScreenEvent
import io.astronout.githubusers.presentation.detail.followers.FollowersScreen
import io.astronout.githubusers.presentation.detail.following.FollowingsScreen
import io.astronout.githubusers.ui.theme.Neutral50
import io.astronout.githubusers.ui.theme.Primary70

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun Tabs(
    userDetails: UserDetails,
    selectedTabIndex: Int,
    onTabChanged: (DetailScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {

    val items = listOf(
        stringResource(id = R.string.label_followers),
        stringResource(id = R.string.label_following)
    )

    val pagerState = rememberPagerState {
        items.size
    }

    LaunchedEffect(key1 = selectedTabIndex, block = {
        pagerState.animateScrollToPage(selectedTabIndex)
    })

    LaunchedEffect(key1 = pagerState.currentPage, key2 = pagerState.isScrollInProgress, block = {
        if (!pagerState.isScrollInProgress) {
            onTabChanged(DetailScreenEvent.ActiveTabIndex(pagerState.currentPage))
        }
    })

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TabRow(
            selectedTabIndex = selectedTabIndex,
            containerColor = Color.White
        ) {
            items.forEachIndexed { index, item ->
                Tab(
                    selected = (index == selectedTabIndex),
                    onClick = {
                        onTabChanged(DetailScreenEvent.ActiveTabIndex(index))
                    },
                    text = {
                        Text(
                            text = item,
                            style = MaterialTheme.typography.titleSmall,
                            color = if (index == selectedTabIndex) Primary70 else Neutral50,
                        )
                    }
                )
            }
        }
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxWidth()
                .weight(1F)
        ) {
            if (it == 0) {
                FollowersScreen(userDetails)
            } else {
                FollowingsScreen(userDetails)
            }
        }
    }
}