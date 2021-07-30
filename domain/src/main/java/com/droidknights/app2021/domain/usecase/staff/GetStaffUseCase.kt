package com.droidknights.app2021.domain.usecase.staff

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.User
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetStaffUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<User>>(dispatcher) {
    override suspend fun execute(): List<User> {
        return conferenceRepository.getStaff()
            .sortedBy { it.name }
    }
}