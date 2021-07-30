package com.droidknights.app2021.setting.ui

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
import com.droidknights.app2021.core.ui.compose.util.toColor
import com.droidknights.app2021.setting.ScreenAction

@Composable
internal fun SettingScreen(
    onScreenAction: (ScreenAction) -> Unit,
) {
    Scaffold(
        topBar = {
            Column(
                Modifier
                    .fillMaxWidth()
                    .padding(24.dp)) {
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
            CellItem("Speaker") {
                onScreenAction(ScreenAction.Speaker)
            }
            Divider(
                color = "#EFEFEF".toColor(),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .height(1.dp)
            )
            CellItem("Contributors") {
                onScreenAction(ScreenAction.Contributor)
            }
            Divider(
                color = "#EFEFEF".toColor(),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .height(1.dp)
            )
            CellItem("Staff") {
                onScreenAction(ScreenAction.Staff)
            }
            Divider(
                color = "#EFEFEF".toColor(),
                modifier = Modifier
                    .padding(horizontal = 24.dp)
                    .height(1.dp)
            )
        }
    }
}

@Composable
private fun CellItem(
    text: String,
    onClicked: () -> Unit
) {
    Text(
        text = text,
        color = Color.Black,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 62.dp)
            .clickable { onClicked() }
            .padding(horizontal = 24.dp)
            .wrapContentHeight()
    )
}
