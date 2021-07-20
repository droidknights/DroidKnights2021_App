package com.droidknights.app2021.shared.model

import com.droidknights.app2021.shared.Level
import com.droidknights.app2021.shared.Tag
import kotlinx.datetime.LocalDateTime
import kotlinx.serialization.Serializable

@Serializable
data class Session(
    val title: String,
    val content: String,
    val speakers: List<Speaker>,
    val level: Level,
    val tags: List<Tag>,
    val room: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
)

@Serializable
data class Speaker(
    val name: String,
    val photoUrl: String
)
