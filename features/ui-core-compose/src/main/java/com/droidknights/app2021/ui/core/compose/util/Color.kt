package com.droidknights.app2021.ui.core.compose.util

import androidx.compose.ui.graphics.Color
import com.droidknights.app2021.shared.HexColor

val String.toColor: Color
    get() = Color(android.graphics.Color.parseColor(this))

val HexColor.toColor: Color
    get() = this.value.toColor