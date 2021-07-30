package com.droidknights.app2021.shared.di

import com.droidknights.app2021.shared.JsonRawString

interface AssetProvider {
    suspend fun getRawSessions(): JsonRawString

    suspend fun getRawEventHistory(): JsonRawString

    suspend fun getRawSponsors(): JsonRawString

    suspend fun getRawStaff(): JsonRawString
}