package com.droidknights.app2021.domain.usecase.contributor

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.domain.UseCase
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.User
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetContributorsUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : UseCase<GetContributorsUseCase.Param, List<User>>(dispatcher) {
    override suspend fun execute(param: Param): List<User> {
        return conferenceRepository.getContributors(
            owner = param.owner,
            name = param.name,
            pageNo = param.pageNo
        )
    }

    data class Param(
        val owner: String,
        val name: String,
        val pageNo: Int
    )
}