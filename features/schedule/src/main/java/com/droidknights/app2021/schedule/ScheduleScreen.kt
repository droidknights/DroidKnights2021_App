package com.droidknights.app2021.schedule

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.droidknights.app2021.model.Session
import com.droidknights.app2021.ui.core.compose.util.color

@Composable
fun ScheduleScreen(
    sessions: List<Session>,
    onSessionClick: (Session) -> Unit = {}
) {
    LazyColumn {
        items(sessions) { session ->
            SessionUi(
                session = session,
                onSessionClick = onSessionClick
            )
            Divider(
                modifier = Modifier.padding(horizontal = 24.dp),
                color = "#EFEFEF".color
            )
        }
    }
}