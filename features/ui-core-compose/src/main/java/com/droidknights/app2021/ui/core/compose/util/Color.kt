package com.droidknights.app2021.ui.core.compose.util

import androidx.compose.ui.graphics.Color
import com.droidknights.app2021.shared.HexColor

fun String.toColor(): Color =
    Color(android.graphics.Color.parseColor(this))

fun HexColor.toColor(): Color =
    value.toColor()