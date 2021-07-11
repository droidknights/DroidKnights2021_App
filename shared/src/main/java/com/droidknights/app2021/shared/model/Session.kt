package com.droidknights.app2021.shared.model

import com.droidknights.app2021.shared.HexColor
import kotlinx.datetime.LocalDateTime

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

data class Level(
    val title: String,
    val color: HexColor
)

data class Tag(
    val title: String,
    val color: HexColor
)

data class Speaker(
    val name: String,
    val photoUrl: String
)