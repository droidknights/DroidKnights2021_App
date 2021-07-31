package com.droidknights.app2021.setting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.droidknights.app2021.core.ui.compose.extension.toUiState
import com.droidknights.app2021.core.ui.compose.state.UiState
import com.droidknights.app2021.domain.usecase.contributor.GetContributorsUseCase
import com.droidknights.app2021.domain.usecase.session.GetSessionsUseCase
import com.droidknights.app2021.domain.usecase.staff.GetStaffUseCase
import com.droidknights.app2021.shared.result.map
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase,
    private val getStaffUseCase: GetStaffUseCase,
    private val getContributorsUseCase: GetContributorsUseCase
) : ViewModel() {
    val speakers = liveData {
        emit(UiState.loading())
        emit(
            getSessionsUseCase()
                .map { list ->
                    list.flatMap {
                        it.speakers
                    }.distinct()
                        .sortedBy { it.name }
                }.toUiState()
        )
    }

    val staff = liveData {
        emit(UiState.loading())
        emit(getStaffUseCase().toUiState())
    }

    val contributors = liveData {
        emit(UiState.loading())
        emit(
            getContributorsUseCase(
                GetContributorsUseCase.Param(
                    "droidknights",
                    "DroidKnights2020_App",
                    1
                )
            ).toUiState()
        )
    }
}