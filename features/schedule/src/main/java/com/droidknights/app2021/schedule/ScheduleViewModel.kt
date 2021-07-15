package com.droidknights.app2021.schedule

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.droidknights.app2021.domain.usecase.session.GetSessionsUseCase
import com.droidknights.app2021.shared.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ScheduleViewModel @Inject constructor(
    private val GetSessionsUseCase: GetSessionsUseCase
) : ViewModel() {
    val sessions = liveData {
        emit(Result.Loading)
        emit(GetSessionsUseCase())
    }
}