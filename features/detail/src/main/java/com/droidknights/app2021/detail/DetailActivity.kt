package com.droidknights.app2021.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.viewModels
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.droidknights.app2021.ui.core.compose.setThemeContent
import com.droidknights.app2021.ui.core.startActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {

    private val viewModel by viewModels<DetailViewModel>()

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

    companion object {
        fun start(context: Context, sessionId: Int) {
            context.startActivity<DetailActivity>(
                "sessionId" to sessionId
            )
        }
    }
}