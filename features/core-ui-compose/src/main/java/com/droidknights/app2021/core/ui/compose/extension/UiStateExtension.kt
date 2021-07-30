package com.droidknights.app2021.core.ui.compose.extension

import com.droidknights.app2021.core.ui.compose.state.UiState
import com.droidknights.app2021.shared.result.Result

fun <T> Result<T>.toUiState(): UiState<T> {
    return when (this) {
        is Result.Error -> UiState(exception = this.exception)
        Result.Loading -> UiState.loading()
        is Result.Success -> UiState.success(value = this.data)
    }
}