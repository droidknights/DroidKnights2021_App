package com.droidknights.app2021.detail

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.droidknights.app2021.ui.core.compose.setThemeContent

class DetailActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            Scaffold(
                topBar = {
                    DetailAppBar(
                        title = "세션 소개",
                        onNavigationClick = { onBackPressed() },
                        onSharedClick = { /** TBD */ }
                    )
                }
            ) { contentPadding ->
                DetailScreen(Modifier.padding(contentPadding))
            }
        }
    }
}