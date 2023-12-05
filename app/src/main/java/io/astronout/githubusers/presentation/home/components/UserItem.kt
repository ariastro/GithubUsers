package io.astronout.githubusers.presentation.home.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.material3.Divider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.astronout.core.domain.model.User
import io.astronout.core.components.NetworkImage
import io.astronout.githubusers.ui.theme.Accent50
import io.astronout.githubusers.ui.theme.Neutral10
import io.astronout.githubusers.ui.theme.Primary80

@Composable
fun UserItem(
    user: User,
    modifier: Modifier = Modifier,
    onEvent: (User) -> Unit
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(20.dp),
        modifier = modifier
            .fillMaxWidth()
            .clickable {
                onEvent(user)
            }
    ) {
        NetworkImage(
            url = user.avatarUrl,
            modifier = Modifier
                .size(70.dp)
                .clip(CircleShape)
        )
        Column(
            modifier = Modifier.weight(1F),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = user.login,
                style = MaterialTheme.typography.bodyLarge,
                color = Primary80
            )
            Text(
                text = user.url,
                style = MaterialTheme.typography.labelMedium,
                color = Accent50
            )
            Divider(
                color = Neutral10,
                modifier = Modifier.fillMaxWidth().height(1.dp).padding(top = 20.dp)
            )
        }
        Icon(
            imageVector = Icons.Default.KeyboardArrowRight,
            contentDescription = null,
            tint = Primary80,
            modifier = Modifier.size(24.dp)
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewUserItem() {
    UserItem(user = User("ariastro", 1, "1", "https://avatars.githubusercontent.com/u/37070447?v=4", "https://github.com/ariastro", "User")) {

    }
}