package com.droidknights.app2021.detail.navigation

import android.content.Context
import com.droidknights.app2021.detail.DetailActivity
import com.droidknights.app2021.navigator.DetailNavigator
import com.droidknights.app2021.shared.model.Session
import javax.inject.Inject

internal class DetailNavigatorImpl @Inject constructor() : DetailNavigator {
    override fun openDetail(context: Context, session: Session) {
        DetailActivity.start(context, session)
    }
}