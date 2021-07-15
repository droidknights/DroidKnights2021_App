package com.droidknights.app2021.domain.mapper

import com.droidknights.app2021.shared.HexColor
import com.droidknights.app2021.shared.model.Level

internal fun String.toLevel(): Level {
    val color: HexColor = when (this) {
        "심화" -> "#897DAD"
        "중급" -> "#E59B86"
        else -> "#ABC192"
    }
    return Level(this, color)
}
