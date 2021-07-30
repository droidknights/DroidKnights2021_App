package com.droidknights.app2021.setting.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.droidknights.app2021.domain.usecase.staff.GetStaffUseCase
import com.droidknights.app2021.shared.result.Result
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    private val getStaffUseCase: GetStaffUseCase
) : ViewModel() {
    val staff = liveData {
        emit(Result.Loading)
        emit(getStaffUseCase())
    }
}