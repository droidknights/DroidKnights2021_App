package com.droidknights.app2021.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.droidknights.app2021.domain.usecase.session.GetSessionsUseCase
import com.droidknights.app2021.ui.core.compose.extension.toUiState
import com.droidknights.app2021.ui.core.compose.state.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase
) : ViewModel() {
    val sessions = liveData {
        emit(UiState.loading())
        emit(getSessionsUseCase().toUiState())
    }
}