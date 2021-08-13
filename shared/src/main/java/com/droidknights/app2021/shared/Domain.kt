package com.droidknights.app2021.shared

import com.droidknights.app2021.shared.serializable.RoomAsStringSerializer
import kotlinx.serialization.Serializable

@JvmInline
value class JsonRawString(val value: String)

@Serializable
@JvmInline
value class HexColor(val value: String)

@Serializable
@JvmInline
value class Level(val name: String)

@Serializable
@JvmInline
value class Tag(val name: String)

@Serializable(RoomAsStringSerializer::class)
enum class Room {
    Track1,
    Track2,
    Etc
}