package com.droidknights.app2021.setting.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidknights.app2021.core.ui.compose.layout.FullScreenLoading
import com.droidknights.app2021.core.ui.compose.layout.LoadingContent
import com.droidknights.app2021.core.ui.compose.setThemeContent
import com.droidknights.app2021.core.ui.compose.state.UiState
import com.droidknights.app2021.core.ui.extraNotNull
import com.droidknights.app2021.setting.Route
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SettingNavigationActivity : AppCompatActivity() {

    private val type by extraNotNull<Route>("type")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setThemeContent {
            when (type) {
                Route.Speaker -> SpeakerContainer { onBackPressed() }
                Route.Contributor -> ContributorContainer { onBackPressed() }
                Route.Staff -> StaffContainer { onBackPressed() }
            }
        }
    }
}

@Composable
private fun SpeakerContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.speakers.observeAsState(UiState.loading())
    CommonContainer(result) {
        SpeakerScreen(
            speakers = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}

@Composable
private fun ContributorContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.contributors.observeAsState(UiState.loading())
    CommonContainer(result) {
        ContributorScreen(
            contributors = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}

@Composable
private fun StaffContainer(
    viewModel: SettingViewModel = viewModel(),
    onBackAction: () -> Unit
) {
    val result by viewModel.staff.observeAsState(UiState.loading())
    CommonContainer(result) {
        StaffScreen(
            staffs = result.getOrThrow(),
            onBackAction = onBackAction
        )
    }
}

@Composable
private fun <T> CommonContainer(
    result: UiState<T>,
    content: @Composable () -> Unit
) {
    val scrollState = rememberScrollState()

    LoadingContent(
        loading = result.initialLoad,
        loadingContent = { FullScreenLoading() },
        error = result.hasError,
        errorContent = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(scrollState)
                    .padding(24.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Icon(
                    imageVector = Icons.Filled.Warning,
                    modifier = Modifier.size(64.dp),
                    contentDescription = null
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text(
                    text = result.exception?.stackTraceToString().orEmpty(),
                    modifier = Modifier.fillMaxWidth()
                )
            }
        },
        content = content
    )
}