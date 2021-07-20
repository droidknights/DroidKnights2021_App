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
import com.droidknights.app2021.shared.ext.color
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.ui.core.compose.layout.Tag
import com.droidknights.app2021.ui.core.compose.util.toColor
import com.google.accompanist.flowlayout.FlowRow

@Composable
fun SessionUi(
    modifier: Modifier = Modifier,
    session: Session,
    onSessionClick: (Session) -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxWidth()
            .clickable { onSessionClick(session) }
            .padding(horizontal = 24.dp, vertical = 20.dp)
    ) {
        Text(
            text = session.title,
            color = Color.Black,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(5.dp))
        Text(
            text = session.speakers.joinToString(separator = " · ", transform = { it.name }),
            color = "#9A9A9A".toColor(),
            fontSize = 14.sp,
        )
        Spacer(modifier = Modifier.height(8.dp))
        FlowRow(mainAxisSpacing = 6.dp, crossAxisSpacing = 6.dp) {
            Tag(text = session.level.name, color = session.level.color.toColor())
            session.tags.forEach { tag ->
                Tag(text = tag.name, color = tag.color.toColor())
            }
        }
    }
}