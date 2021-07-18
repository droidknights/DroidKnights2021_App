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
        return JsonRawString(AssetUtil.loadAsset(context, "sessions.json"))
    }

    override suspend fun getRawEventHistory(): JsonRawString {
        return JsonRawString(AssetUtil.loadAsset(context, "event.json"))
    }

    override suspend fun getRawSponsors(): JsonRawString {
        return JsonRawString(AssetUtil.loadAsset(context, "sponsor.json"))
    }
}