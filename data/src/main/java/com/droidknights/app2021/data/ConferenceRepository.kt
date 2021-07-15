package com.droidknights.app2021.data

import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.shared.model.Sponsor

interface ConferenceRepository {
    suspend fun getEventHistory(): List<Event>

    suspend fun getSessions(): List<Session>

    suspend fun getSponsors(): List<Sponsor>
}
