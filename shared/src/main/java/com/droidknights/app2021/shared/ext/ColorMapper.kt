package com.droidknights.app2021.shared.ext

import com.droidknights.app2021.shared.HexColor
import com.droidknights.app2021.shared.Level
import com.droidknights.app2021.shared.Tag

val Level.color: HexColor
    get() {
        val color = when (name) {
            "심화" -> "#897DAD"
            "중급" -> "#E59B86"
            else -> "#ABC192"
        }
        return HexColor(color)
    }

val Tag.color: HexColor
    get() {
        val color = when (name) {
            "기술", "Architecture" -> "#6EA8A8"
            "Framework" -> "#897DAD"
            "Jetpack" -> "#073042"
            "Kotlin" -> "#E59B86"
            "UI", "경험" -> "#92B9E9"
            "생산성" -> "#C494D6"
            "크로스플랫폼" -> "#E78989"
            "Flutter" -> "#9188B0"
            "Android" -> "#3DDC84"
            "Improve" -> "#F86734"
            else -> "#ABC192"
        }
        return HexColor(color)
    }