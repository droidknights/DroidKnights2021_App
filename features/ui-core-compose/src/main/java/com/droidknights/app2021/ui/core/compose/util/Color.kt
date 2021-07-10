package com.droidknights.app2021.ui.core.compose.util

import androidx.compose.ui.graphics.Color

val String.color: Color
    get() = Color(android.graphics.Color.parseColor(this))