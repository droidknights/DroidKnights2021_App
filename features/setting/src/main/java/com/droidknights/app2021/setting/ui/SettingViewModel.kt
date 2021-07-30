package com.droidknights.app2021.setting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.droidknights.app2021.domain.usecase.session.GetSessionsUseCase
import com.droidknights.app2021.domain.usecase.staff.GetStaffUseCase
import com.droidknights.app2021.shared.result.Result
import com.droidknights.app2021.shared.result.data
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getSessionsUseCase: GetSessionsUseCase,
    private val getStaffUseCase: GetStaffUseCase
) : ViewModel() {
    val speakers = liveData {
        emit(Result.Loading)
        val users = getSessionsUseCase().data.orEmpty()
            .flatMap {
                it.speakers
            }.distinct()
            .sortedBy { it.name }
        emit(Result.Success(users))
    }

    val staff = liveData {
        emit(Result.Loading)
        emit(getStaffUseCase())
    }
}