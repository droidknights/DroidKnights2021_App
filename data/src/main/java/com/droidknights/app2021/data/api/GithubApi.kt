package com.droidknights.app2021.data.api

import com.droidknights.app2021.data.model.GithubContributors
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface GithubApi {
    @GET("repos/{owner}/{name}/contributors?per_page=30")
    suspend fun getContributors(
        @Path("owner") owner: String,
        @Path("name") name: String,
        @Query("page") page: Int
    ): List<GithubContributors>
}