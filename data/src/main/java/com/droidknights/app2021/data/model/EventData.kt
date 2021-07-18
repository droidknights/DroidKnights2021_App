package com.droidknights.app2021.data.model

import com.droidknights.app2021.shared.model.Event
import kotlinx.serialization.Serializable

@Serializable
internal data class EventContainer(
    val events: List<Event> = emptyList()
)
