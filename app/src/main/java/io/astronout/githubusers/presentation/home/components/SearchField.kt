package io.astronout.githubusers.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Send
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import io.astronout.githubusers.R
import io.astronout.githubusers.presentation.home.HomeScreenEvent
import io.astronout.githubusers.ui.theme.Neutral10
import io.astronout.githubusers.ui.theme.Neutral40
import io.astronout.githubusers.ui.theme.Primary50

@Composable
fun SearchField(
    query: String,
    onEvent: (HomeScreenEvent) -> Unit,
    modifier: Modifier = Modifier
) {
    TextField(
        value = query,
        onValueChange = {
            onEvent(HomeScreenEvent.OnSearchQueryChange(it))
        },
        textStyle = MaterialTheme.typography.bodyLarge,
        placeholder = {
            Text(
                text = "Search...",
                color = Neutral40,
                style = MaterialTheme.typography.bodyLarge
            )
        },
        leadingIcon = {
            Icon(
                painterResource(id = R.drawable.ic_search),
                contentDescription = null,
                modifier = Modifier.size(32.dp)
            )
        },
        trailingIcon = {
            Icon(
                imageVector = if (query.isEmpty()) Icons.Default.Send else Icons.Default.Clear,
                contentDescription = null,
                tint = Primary50,
                modifier = Modifier.clickable(
                    interactionSource = remember { MutableInteractionSource() },
                    indication = rememberRipple(bounded = false),
                    onClick = {
                        if (query.isNotEmpty()) {
                            onEvent(HomeScreenEvent.ClearSearch)
                        }
                    }
                )
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Neutral10,
            unfocusedContainerColor = Neutral10,
            disabledContainerColor = Neutral10,
            cursorColor = Color.Black,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledLabelColor = Color.Blue,
        ),
        maxLines = 1,
        singleLine = true,
        modifier = modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
    )
}