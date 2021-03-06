package com.droidknights.app2021.shared.model

import com.droidknights.app2021.shared.Level
import com.droidknights.app2021.shared.Room
import com.droidknights.app2021.shared.Tag
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val title: String,
    val content: List<String>,
    val speakers: List<User>,
    val level: Level,
    val tags: List<Tag>,
    val room: Room,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val contentLink: String? = null
)
