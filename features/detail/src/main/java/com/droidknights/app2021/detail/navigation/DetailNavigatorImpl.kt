package com.droidknights.app2021.detail.navigation

import android.content.Context
import com.droidknights.app2021.detail.DetailActivity
import com.droidknights.app2021.navigator.DetailNavigator
import javax.inject.Inject

class DetailNavigatorImpl @Inject constructor() : DetailNavigator {
    override fun openDetail(context: Context, sessionId: Int) {
        DetailActivity.start(context, sessionId)
    }
}