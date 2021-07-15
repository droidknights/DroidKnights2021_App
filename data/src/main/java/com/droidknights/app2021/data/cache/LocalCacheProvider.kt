package com.droidknights.app2021.data.cache

import com.droidknights.app2021.shared.model.*
import kotlinx.datetime.TimeZone
import kotlinx.datetime.toInstant
import kotlinx.datetime.toLocalDate
import kotlinx.datetime.toLocalDateTime
import javax.inject.Inject
import kotlin.random.Random

class LocalCacheProvider @Inject constructor(
) {
    suspend fun getSessions(): List<Session> {
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

    suspend fun getEventHistory(): List<Event> {
        return listOf(
            Event(
                date = "2021-09-25".toLocalDate(),
                url = "",
                isEndEvent = false
            ),
            Event(
                date = "2020-09-05".toLocalDate(),
                url = "https://droidknights.github.io/2020/"
            ),
            Event(
                date = "2019-04-05".toLocalDate(),
                url = "https://droidknights.github.io/2019/"
            ),
            Event(
                date = "2018-04-22".toLocalDate(),
                url = "https://droidknights.github.io/2018/"
            ),
            Event(
                date = "2017-03-25".toLocalDate(),
                url = "https://droidknights.github.io/2017/"
            ),
        )
    }

    suspend fun getSponsors(): List<Sponsor> {
        return listOf(
            Sponsor(
                name = "toss",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_toss.png",
                homepage = "https://toss.im/"
            ),
            Sponsor(
                name = "헤이딜러",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_heydealer.png",
                homepage = "https://dealer.heydealer.com/"
            ),
            Sponsor(
                name = "카카오페이",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_kakaopay.png",
                homepage = "https://www.kakaopay.com/"
            ),
            Sponsor(
                name = "VCNC",
                photoUrl = "https://raw.githubusercontent.com/droidknights/DroidKnights2020_App/master/androidapp/app/src/main/res/drawable-xxxhdpi/ic_sponsor_vcnc.png",
                homepage = "https://tadacareer.vcnc.co.kr/"
            )
        )
    }
}