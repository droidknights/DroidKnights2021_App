package com.droidknights.app2021.data.model

import com.droidknights.app2021.shared.model.Speaker
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
internal data class SessionContainer(
    val sessions: List<SessionData> = emptyList()
)

@Serializable
data class SessionData(
    val title: String,
    val content: String,
    val speakers: List<Speaker>,
    val level: String,
    val tags: List<String> = emptyList(),
    val room: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
)