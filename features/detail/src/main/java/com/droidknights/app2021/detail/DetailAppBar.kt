package com.droidknights.app2021.detail

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.core.ui.compose.util.toColor

@Composable
fun DetailAppBar(
    title: String,
    onNavigationClick: () -> Unit = {},
    onSharedClick: () -> Unit = {},
) {
    TopAppBar(backgroundColor = Color.White) {
        Row {
            IconButton(onClick = onNavigationClick) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = null
                )
            }
            Text(
                text = title, fontSize = 18.sp, color = "#2F2E32".toColor(),
                modifier = Modifier
                    .weight(1f)
                    .wrapContentWidth()
                    .align(Alignment.CenterVertically)
            )
            IconButton(onClick = onSharedClick) {
                Icon(
                    imageVector = Icons.Filled.Share,
                    contentDescription = null
                )
            }
        }
    }
}