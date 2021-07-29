package com.droidknights.app2021.setting

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.ui.core.compose.util.toColor

@Composable
fun SettingScreen(
    onContributorClicked: () -> Unit
) {
    Scaffold(
        topBar = {
            Column(Modifier.padding(24.dp)) {
                Text(
                    text = "설정",
                    color = "#2F2E32".toColor(),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    ) { innerPadding ->
        Column(Modifier.padding(innerPadding)) {
            Text(
                text = "Contributors",
                color = Color.Black,
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier
                    .fillMaxWidth()
                    .heightIn(min = 62.dp)
                    .clickable { onContributorClicked() }
                    .padding(horizontal = 24.dp)
                    .wrapContentHeight()
            )

            Divider(
                color = "#EFEFEF".toColor(),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .height(1.dp)
            )
        }
    }
}