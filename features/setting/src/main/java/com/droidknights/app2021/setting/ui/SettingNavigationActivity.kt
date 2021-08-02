package com.droidknights.app2021.setting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.droidknights.app2021.core.ui.compose.setThemeContent
import com.droidknights.app2021.core.ui.extraNotNull
import com.droidknights.app2021.setting.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingNavigationActivity : AppCompatActivity() {

    private val type by extraNotNull<Route>("type")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            NavigationContainer(
                type = type,
                onBackAction = { onBackPressed() }
            )
        }
    }
}
