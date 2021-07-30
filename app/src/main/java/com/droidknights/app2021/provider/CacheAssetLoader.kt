package com.droidknights.app2021.provider

import android.content.Context
import com.droidknights.app2021.shared.JsonRawString
import com.droidknights.app2021.shared.di.AssetProvider
import com.droidknights.app2021.util.AssetUtil
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class CacheAssetLoader @Inject constructor(
    @ApplicationContext private val context: Context
) : AssetProvider {
    override suspend fun getRawSessions(): JsonRawString {
        return getJsonRawString("sessions.json")
    }

    override suspend fun getRawEventHistory(): JsonRawString {
        return getJsonRawString("event.json")
    }

    override suspend fun getRawSponsors(): JsonRawString {
        return getJsonRawString("sponsor.json")
    }

    override suspend fun getRawStaff(): JsonRawString {
        return getJsonRawString("staff.json")
    }

    private fun getJsonRawString(fileName: String): JsonRawString {
        return JsonRawString(AssetUtil.loadAsset(context, fileName))
    }
}