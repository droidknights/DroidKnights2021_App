package com.droidknights.app2021.domain.usecase.session

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.domain.mapper.toLevel
import com.droidknights.app2021.domain.mapper.toTag
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.Session
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class GetSessionsUseCase @Inject constructor(
    private val conferenceRepository: ConferenceRepository,
    @IoDispatcher dispatcher: CoroutineDispatcher,
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        return conferenceRepository.getSessions()
            .map {
                Session(
                    title = it.title,
                    content = it.content,
                    speakers = it.speakers,
                    level = it.level.toLevel(),
                    tags = it.tags.map { tag ->
                        tag.toTag()
                    },
                    room = it.room,
                    startTime = it.startTime,
                    endTime = it.endTime
                )
            }
    }
}