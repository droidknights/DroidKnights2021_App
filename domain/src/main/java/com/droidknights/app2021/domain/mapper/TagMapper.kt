package com.droidknights.app2021.domain.mapper

import com.droidknights.app2021.shared.HexColor
import com.droidknights.app2021.shared.model.Tag

internal fun String.toTag(): Tag {
    val color: HexColor = when (this) {
        "기술", "Architecture" -> "#6EA8A8"
        "Framework" -> "#897DAD"
        "Kotlin" -> "#E59B86"
        "UI", "경험" -> "#92B9E9"
        "생산성" -> "#C494D6"
        "크로스플랫폼" -> "#E78989"
        "Flutter" -> "#9188B0"
        else -> "#ABC192"
    }
    return Tag(this, color)
}