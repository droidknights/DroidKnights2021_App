package com.droidknights.app2021.home.util

import android.content.Context
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.net.toUri

fun Context.startOpenUrl(url: String) {
    CustomTabsIntent.Builder()
        .build()
        .launchUrl(this, url.toUri())

}
