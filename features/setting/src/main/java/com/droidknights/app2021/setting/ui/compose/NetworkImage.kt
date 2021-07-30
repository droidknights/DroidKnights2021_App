package com.droidknights.app2021.setting.ui.compose

import androidx.compose.foundation.Image
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import coil.annotation.ExperimentalCoilApi
import coil.compose.ImagePainter
import coil.compose.rememberImagePainter
import coil.request.ImageRequest
import com.droidknights.app2021.setting.R

@OptIn(ExperimentalCoilApi::class)
@Composable
internal fun NetworkImage(
    imageUrl: String,
    nonSuccessTintColor: Color,
    modifier: Modifier = Modifier,
    builder: ImageRequest.Builder.() -> Unit = {
        crossfade(true)
        placeholder(R.drawable.ic_black_android_24)
        error(R.drawable.ic_black_android_24)
    },
) {
    val painter = rememberImagePainter(
        data = imageUrl,
        builder = builder,
    )

    val colorFilter = when (painter.state) {
        is ImagePainter.State.Success -> null
        else -> ColorFilter.tint(nonSuccessTintColor)
    }

    Image(
        modifier = modifier,
        painter = painter,
        colorFilter = colorFilter,
        contentDescription = null
    )
}