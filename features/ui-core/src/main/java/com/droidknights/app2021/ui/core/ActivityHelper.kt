package com.droidknights.app2021.ui.core

import android.content.Context
import android.content.Intent
import android.net.Uri

class ActivityHelper {
    companion object {
        fun startActionView(context: Context, uri: String) {
            if (uri.isEmpty()) return
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(uri)).apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
            context.startActivity(intent)
        }
    }
}