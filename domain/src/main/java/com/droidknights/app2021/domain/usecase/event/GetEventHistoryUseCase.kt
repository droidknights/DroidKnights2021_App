package com.droidknights.app2021.domain.usecase.event

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.Event
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetEventHistoryUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<Event>>(dispatcher) {
    override suspend fun execute(): List<Event> {
        return conferenceRepository.getEventHistory()
    }
}