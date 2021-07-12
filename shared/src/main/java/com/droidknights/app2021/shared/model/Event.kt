package com.droidknights.app2021.shared.model

import kotlinx.datetime.LocalDate
import kotlinx.serialization.Serializable

@Serializable
data class Event(
    val date: LocalDate,
    val url: String,
    val isEndEvent: Boolean = true
)