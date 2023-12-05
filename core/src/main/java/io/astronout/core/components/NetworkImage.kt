package io.astronout.core.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
import com.skydoves.landscapist.ImageOptions
import com.skydoves.landscapist.glide.GlideImage
import io.astronout.core.R

@Composable
fun NetworkImage(
    url: String,
    modifier: Modifier = Modifier,
    contentScale: ContentScale = ContentScale.Crop,
) {
    GlideImage(
        imageModel = { url },
        requestOptions = {
            RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
        },
        imageOptions = ImageOptions(
            contentScale = contentScale
        ),
        modifier = modifier
    )
}