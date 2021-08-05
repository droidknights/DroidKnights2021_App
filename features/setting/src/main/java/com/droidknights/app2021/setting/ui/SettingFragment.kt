package com.droidknights.app2021.setting.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.platform.LocalContext
import androidx.fragment.app.Fragment
import com.droidknights.app2021.core.ui.compose.setThemeContent
import com.droidknights.app2021.core.ui.startActivity
import com.droidknights.app2021.setting.Route
import com.droidknights.app2021.setting.ScreenAction
import com.droidknights.app2021.setting.ui.detail.SettingDetailActivity
import com.droidknights.app2021.setting.ui.detail.SettingScreen

class SettingFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            val context = LocalContext.current

            SettingScreen { action ->
                val route = when (action) {
                    ScreenAction.Speaker -> Route.Speaker
                    ScreenAction.Contributor -> Route.Contributor
                    ScreenAction.Staff -> Route.Staff
                }

                context.startActivity<SettingDetailActivity>(
                    "type" to route
                )
            }
        }
    }
}
