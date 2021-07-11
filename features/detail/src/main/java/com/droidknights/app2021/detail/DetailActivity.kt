package com.droidknights.app2021.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.ui.Modifier
import com.droidknights.app2021.detail.util.map
import com.droidknights.app2021.shared.ext.decodeFromString
import com.droidknights.app2021.shared.ext.encodeToString
import com.droidknights.app2021.shared.model.Session
import com.droidknights.app2021.ui.core.compose.setThemeContent
import com.droidknights.app2021.ui.core.extraNotNull
import com.droidknights.app2021.ui.core.startActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : ComponentActivity() {

    private val session by extraNotNull<String>("session")
        .map { encodeString ->
            encodeString.decodeFromString<Session>()
        }

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
                DetailScreen(
                    session = session,
                    modifier = Modifier.padding(contentPadding)
                )
            }
        }
    }

    companion object {
        fun start(context: Context, session: Session) {
            context.startActivity<DetailActivity>(
                "session" to session.encodeToString()
            )
        }
    }
}