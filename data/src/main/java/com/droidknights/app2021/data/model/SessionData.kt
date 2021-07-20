package com.droidknights.app2021.data.model

import com.droidknights.app2021.shared.Level
import com.droidknights.app2021.shared.Room
import com.droidknights.app2021.shared.Tag
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
    val level: Level,
    val tags: List<Tag> = emptyList(),
    // TODO: Track1, track1은 Room.Track1으로 매칭되어야한다.
    // TODO: 트랙정보가 올바르게 매칭되지 않을시 Room.Etc로 매칭되어야한다
    val room: Room = Room.Etc,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
)