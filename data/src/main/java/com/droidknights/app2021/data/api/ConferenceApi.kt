package com.droidknights.app2021.data.api

import com.droidknights.app2021.data.model.SessionData
import com.droidknights.app2021.shared.model.Event
import com.droidknights.app2021.shared.model.Sponsor
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/droidknights/DroidKnights2021_App/master/app/src/main/assets/sessions.json")
    suspend fun getSessions(): List<SessionData>

    @GET("/droidknights/DroidKnights2021_App/master/app/src/main/assets/event.json")
    suspend fun getEventHistory(): List<Event>

    @GET("/droidknights/DroidKnights2021_App/master/app/src/main/assets/sponsor.json")
    suspend fun getSponsors(): List<Sponsor>
}