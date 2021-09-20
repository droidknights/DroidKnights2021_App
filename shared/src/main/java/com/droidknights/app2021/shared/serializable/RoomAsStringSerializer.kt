package com.droidknights.app2021.shared.serializable

import com.droidknights.app2021.shared.Room
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.*
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

class RoomAsStringSerializer: KSerializer<Room> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor(javaClass.name, PrimitiveKind.STRING)

    override fun serialize(encoder: Encoder, value: Room) {
        encoder.encodeString(value.name)
    }

    override fun deserialize(decoder: Decoder): Room {
        val decodedString = decoder.decodeString()
        return Room.values().find { it.name.lowercase() == decodedString.lowercase() } ?: Room.Etc
    }
}