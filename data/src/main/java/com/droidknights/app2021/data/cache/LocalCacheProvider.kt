package com.droidknights.app2021.data.cache

import com.droidknights.app2021.data.model.*
import com.droidknights.app2021.shared.di.AssetProvider
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Sponsor
import com.droidknights.app2021.shared.model.User
import kotlinx.serialization.json.Json
import javax.inject.Inject

class LocalCacheProvider @Inject constructor(
    private val assetProvider: AssetProvider
) {
    private val json = Json {
        ignoreUnknownKeys = true
        coerceInputValues = true
    }

    suspend fun getSessions(): List<SessionData> {
        return json.decodeFromString(
            SessionContainer.serializer(),
            assetProvider.getRawSessions().value
        ).sessions
    }

    suspend fun getEventHistory(): List<Event> {
        return json.decodeFromString(
            EventContainer.serializer(),
            assetProvider.getRawEventHistory().value
        ).events
    }

    suspend fun getSponsors(): List<Sponsor> {
        return json.decodeFromString(
            SponsorContainer.serializer(),
            assetProvider.getRawSponsors().value
        ).sponsors
    }

    suspend fun getStaff(): List<User> {
        return json.decodeFromString(
            StaffContainer.serializer(),
            assetProvider.getRawStaff().value
        ).staff
    }
}