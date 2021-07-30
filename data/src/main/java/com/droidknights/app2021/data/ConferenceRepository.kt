package com.droidknights.app2021.data

import com.droidknights.app2021.data.model.SessionData
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Sponsor
import com.droidknights.app2021.shared.model.User

interface ConferenceRepository {
    suspend fun getEventHistory(): List<Event>

    suspend fun getSessions(): List<SessionData>

    suspend fun getSponsors(): List<Sponsor>

    suspend fun getStaff(): List<User>

    suspend fun getContributors(
        owner: String,
        name: String,
        pageNo: Int
    ): List<User>
}
