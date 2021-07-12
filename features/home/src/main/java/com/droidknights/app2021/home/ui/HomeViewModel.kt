package com.droidknights.app2021.home.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.droidknights.app2021.domain.event.GetEventHistoryUseCase
import com.droidknights.app2021.domain.sponsor.GetSponsorUseCase
import com.droidknights.app2021.home.model.HomeInfo
import com.droidknights.app2021.shared.result.successOr
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getSponsorUseCase: GetSponsorUseCase,
    private val getEventHistoryUseCase: GetEventHistoryUseCase
) : ViewModel() {

    private val _homeInfo = MutableLiveData<HomeInfo>()
    val homeInfo: LiveData<HomeInfo> get() = _homeInfo

    init {
        viewModelScope.launch {
            val sponsors = async { getSponsorUseCase() }
            val events = async { getEventHistoryUseCase() }

            _homeInfo.value = HomeInfo(
                sponsors = sponsors.await().successOr(emptyList()),
                events = events.await().successOr(emptyList())
            )
        }
    }
}