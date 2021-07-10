package com.droidknights.app2021.schedule

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.ui.core.compose.layout.Tag
import com.droidknights.app2021.ui.core.compose.util.color
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun Session(
    modifier: Modifier = Modifier,
    onSessionClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSessionClick() }
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Text(
            text = "테스트",
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = "발표자",
            color = "#9A9A9A".color,
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))

        FlowRow(mainAxisSpacing = 6.dp) {
            repeat(5) {
                Tag(text = "Tag $it", color = "#897dad".color)
            }
        }
    }
}