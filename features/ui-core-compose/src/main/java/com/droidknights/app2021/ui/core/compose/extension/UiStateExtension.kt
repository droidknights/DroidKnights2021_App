package com.droidknights.app2021.ui.core.compose.extension

import com.droidknights.app2021.shared.result.Result
import com.droidknights.app2021.ui.core.compose.state.UiState

fun <T> Result<T>.toUiState(): UiState<T> {
    return when (this) {
        is Result.Error -> UiState(exception = this.exception)
        Result.Loading -> UiState.loading()
        is Result.Success -> UiState.success(value = this.data)
    }
}