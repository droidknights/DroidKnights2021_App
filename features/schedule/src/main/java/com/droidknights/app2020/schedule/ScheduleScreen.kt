package com.droidknights.app2020.schedule

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Composable
fun ScheduleScreen() {
    Box {
        Text(
            modifier = Modifier
                .fillMaxSize()
                .wrapContentSize(align = Alignment.Center),
            text = "Sample",
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
    }
}