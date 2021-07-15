package com.droidknights.app2021.domain.sponsor

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSponsorUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<Sponsor>>(dispatcher) {
    override suspend fun execute(): List<Sponsor> {
        return conferenceRepository.getSponsors()
    }
}