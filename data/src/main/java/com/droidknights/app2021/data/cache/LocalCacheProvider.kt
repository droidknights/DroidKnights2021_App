package com.droidknights.app2021.data.cache

import com.droidknights.app2021.data.model.SessionContainer
import com.droidknights.app2021.data.model.SessionData
import com.droidknights.app2021.shared.di.AssetProvider
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.datetime.toLocalDate
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocalCacheProvider @Inject constructor(
    private val assetProvider: AssetProvider
) {
    private val json = Json {
        ignoreUnknownKeys = true
    }

    suspend fun getSessions(): List<SessionData> {
        val data = json.decodeFromString(
            SessionContainer.serializer(),
            assetProvider.getRawSessions().value
        )
        return data.sessions
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