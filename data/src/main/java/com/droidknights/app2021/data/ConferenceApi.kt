package com.droidknights.app2021.data

import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.shared.model.Sponsor
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/sessions.json")
    suspend fun getSessions(): List<Session>

    @GET("/event.json")
    suspend fun getEventHistory(): List<Event>

    @GET("/sponsor.json")
    suspend fun getSponsors(): List<Sponsor>
}