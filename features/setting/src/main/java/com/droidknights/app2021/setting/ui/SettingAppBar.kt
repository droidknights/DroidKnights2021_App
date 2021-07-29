package com.droidknights.app2021.setting.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.ui.core.compose.util.toColor

@Composable
internal fun SettingAppBar(
    title: String,
    modifier: Modifier = Modifier
) {
    Surface(
        modifier = modifier,
        elevation = 4.dp
    ) {
        Text(
            text = title,
            color = "#2F2E32".toColor(),
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .fillMaxWidth()
                .padding(24.dp)
        )
    }
}