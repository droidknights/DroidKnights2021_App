package com.droidknights.app2021.domain.session

import com.droidknights.app2021.domain.NonParamCoroutineUseCase
import com.droidknights.app2021.shared.di.IoDispatcher
import com.droidknights.app2021.shared.model.Level
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.shared.model.Speaker
import com.droidknights.app2021.shared.model.Tag
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import kotlin.random.Random

class GetSessionsUseCase @Inject constructor(
    @IoDispatcher dispatcher: CoroutineDispatcher
) : NonParamCoroutineUseCase<List<Session>>(dispatcher) {
    override suspend fun execute(): List<Session> {
        val random = Random(System.currentTimeMillis())
        return mutableListOf<Session>().apply {
            repeat(20) {
                add(
                    Session(
                        title = "Session Title $it",
                        content = "Content $it",
                        speakers = listOf(
                            Speaker(
                                name = "발표자 $it",
                                photoUrl = ""
                            )
                        ),
                        level = Level("중급", color = "#E59B86"),
                        tags = listOf(
                            Tag(title = "Tag ${random.nextInt(10)}", color = "#897dad"),
                            Tag(title = "Tag ${random.nextInt(10)}", color = "#92b9e9")
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