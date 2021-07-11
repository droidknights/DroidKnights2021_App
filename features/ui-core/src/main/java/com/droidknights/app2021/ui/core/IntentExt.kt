package com.droidknights.app2021.ui.core

import androidx.activity.ComponentActivity

inline fun <reified T : Any> ComponentActivity.extra(
    key: String,
    default: T? = null
) = lazy {
    val value = intent.extras?.get(key)
    if (value is String) value else default
}

inline fun <reified T : Any> ComponentActivity.extraNotNull(
    key: String,
    default: T? = null
) = lazy {
    val value = intent.extras?.get(key)
    requireNotNull(if (value is T) value else default) { key }
}