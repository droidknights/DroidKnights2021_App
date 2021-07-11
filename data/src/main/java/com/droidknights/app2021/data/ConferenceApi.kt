package com.droidknights.app2021.data

import com.droidknights.app2021.shared.model.Session
import retrofit2.http.GET

interface ConferenceApi {
    @GET("/sessions.json")
    suspend fun getSessions(): List<Session>
}