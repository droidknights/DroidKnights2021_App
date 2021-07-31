package com.droidknights.app2021.setting.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.core.ui.compose.util.toColor

@Composable
internal fun SettingAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable (() -> Unit)? = null,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                color = "#2F2E32".toColor(),
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold
            )
        },
        navigationIcon = navigationIcon,
        modifier = modifier.fillMaxWidth(),
        backgroundColor = Color.White
    )
}