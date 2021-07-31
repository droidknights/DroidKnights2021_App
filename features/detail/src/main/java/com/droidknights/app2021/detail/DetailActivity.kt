package com.droidknights.app2021.detail

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.droidknights.app2021.core.ui.compose.setThemeContent
import com.droidknights.app2021.core.ui.compose.util.toColor
import com.droidknights.app2021.core.ui.extraNotNull
import com.droidknights.app2021.core.ui.startActivity
import com.droidknights.app2021.detail.util.map
import com.droidknights.app2021.shared.ext.decodeFromString
import com.droidknights.app2021.shared.ext.encodeToString
import com.droidknights.app2021.shared.model.Session
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
            DetailContainer(
                session = session,
                onBackAction = { onBackPressed() },
                onMovieClick = { /** TODO: Youtube 이동 */ }
            )
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

@Composable
private fun DetailContainer(
    session: Session,
    onBackAction: () -> Unit,
    onMovieClick: (Session) -> Unit
) {
    Scaffold(
        topBar = {
            DetailAppBar(
                title = "세션 소개",
                onNavigationClick = { onBackAction() },
                onSharedClick = { /** TBD */ }
            )
        },
        bottomBar = {
            if (session.contentLink != null) {
                Text(
                    text = "영상 보러가기",
                    color = Color.White,
                    fontSize = 16.sp,
                    modifier = Modifier
                        .fillMaxWidth()
                        .background("#43B1B3".toColor())
                        .clickable { onMovieClick(session) }
                        .padding(20.dp)
                        .wrapContentSize(Alignment.Center)
                )
            }
        }
    ) { contentPadding ->
        DetailScreen(
            session = session,
            modifier = Modifier.padding(contentPadding)
        )
    }
}