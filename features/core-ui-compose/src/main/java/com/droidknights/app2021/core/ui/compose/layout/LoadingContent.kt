package com.droidknights.app2021.core.ui.compose.layout

import androidx.compose.runtime.Composable

@Composable
fun LoadingContent(
    loading: Boolean,
    loadingContent: @Composable () -> Unit,
    error: Boolean = false,
    errorContent: @Composable () -> Unit = {},
    content: @Composable () -> Unit
) {
    when {
        loading -> loadingContent()
        error -> errorContent()
        else -> content()
    }
}