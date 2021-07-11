package com.droidknights.app2021.detail.util

internal fun <T, R> Lazy<T>.map(transform: (T) -> R): Lazy<R> {
    return lazy { transform(value) }
}
