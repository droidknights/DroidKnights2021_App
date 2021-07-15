package com.droidknights.app2021.data.repository

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.data.api.ConferenceApi
import com.droidknights.app2021.data.cache.LocalCacheProvider
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.shared.model.Sponsor
import javax.inject.Inject

class ConferenceRepositoryImpl @Inject constructor(
    private val conferenceApi: ConferenceApi,
    private val localCacheProvider: LocalCacheProvider
) : ConferenceRepository {
    override suspend fun getEventHistory(): List<Event> {
        return runCatching {
            conferenceApi.getEventHistory()
        }.getOrDefault(localCacheProvider.getEventHistory())
    }

    override suspend fun getSessions(): List<Session> {
        return runCatching {
            conferenceApi.getSessions()
        }.getOrDefault(localCacheProvider.getSessions())
    }

    override suspend fun getSponsors(): List<Sponsor> {
        return runCatching {
            conferenceApi.getSponsors()
        }.getOrDefault(localCacheProvider.getSponsors())
    }
}