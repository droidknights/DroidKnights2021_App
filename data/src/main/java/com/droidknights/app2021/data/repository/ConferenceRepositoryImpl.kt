package com.droidknights.app2021.data.repository

import com.droidknights.app2021.data.ConferenceRepository
import com.droidknights.app2021.data.api.ConferenceApi
import com.droidknights.app2021.data.api.GithubApi
import com.droidknights.app2021.data.cache.LocalCacheProvider
import com.droidknights.app2021.data.model.SessionData
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Sponsor
import com.droidknights.app2021.shared.model.User
import javax.inject.Inject

internal class ConferenceRepositoryImpl @Inject constructor(
    private val conferenceApi: ConferenceApi,
    private val githubApi: GithubApi,
    private val localCacheProvider: LocalCacheProvider
) : ConferenceRepository {
    override suspend fun getEventHistory(): List<Event> {
        return runCatching {
            conferenceApi.getEventHistory()
        }.getOrDefault(localCacheProvider.getEventHistory())
    }

    override suspend fun getSessions(): List<SessionData> {
        return runCatching {
            conferenceApi.getSessions()
        }.getOrDefault(localCacheProvider.getSessions())
    }

    override suspend fun getSponsors(): List<Sponsor> {
        return runCatching {
            conferenceApi.getSponsors()
        }.getOrDefault(localCacheProvider.getSponsors())
    }

    override suspend fun getStaff(): List<User> {
        return runCatching {
            conferenceApi.getStaff()
        }.getOrDefault(localCacheProvider.getStaff())
    }

    override suspend fun getContributors(
        owner: String,
        name: String,
        pageNo: Int
    ): List<User> {
        return githubApi.getContributors(owner, name, pageNo)
            .map {
                User(
                    name = it.name,
                    photoUrl = it.photoUrl
                )
            }
    }
}