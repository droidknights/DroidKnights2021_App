package com.droidknights.app2021.domain.session

import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.model.Level
import com.droidknights.app2021.model.Session
import com.droidknights.app2021.model.Speaker
import com.droidknights.app2021.model.Tag
import com.droidknights.app2021.shared.di.IoDispatcher
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject

class GetSessionsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        return mutableListOf<Session>().apply {
            repeat(20) {
                add(
                    Session(
                        sessionId = it,
                        title = "Session Title $it",
                        content = "Content $it",
                        speakers = listOf(
                            Speaker(
                                name = "발표자",
                                photoUrl = ""
                            )
                        ),
                        level = Level("중급", color = "#E59B86"),
                        tags = listOf(
                            Tag(title = "Tag 1", color = "#897dad"),
                            Tag(title = "Tag 2", color = "#92b9e9")
                        ),
                        room = "Track1",
                        startTime = "2021-09-25T14:00:00.000Z"
                            .toInstant()
                            .toLocalDateTime(TimeZone.of("Asia/Seoul")),
                        endTime = "2021-09-25T14:30:00.000Z"
                            .toInstant()
                            .toLocalDateTime(TimeZone.of("Asia/Seoul"))
                    )
                )
            }
        }
    }
}