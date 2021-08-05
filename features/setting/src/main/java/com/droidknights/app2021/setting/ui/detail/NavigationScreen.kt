package com.droidknights.app2021.setting.ui.detail

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Warning
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidknights.app2021.core.ui.compose.layout.FullScreenLoading
import com.droidknights.app2021.core.ui.compose.layout.LoadingContent
import com.droidknights.app2021.core.ui.compose.state.UiState
import com.droidknights.app2021.core.ui.compose.util.toColor
import com.droidknights.app2021.setting.Route

@Composable
internal fun NavigationContainer(
    viewModel: SettingViewModel = viewModel(),
    type: Route,
    onBackAction: () -> Unit
) {
    when (type) {
        Route.Speaker -> {
            val result by viewModel.speakers.observeAsState(UiState.loading())
            NavigationScreen(
                result,
                "Speaker",
                onBackAction
            ) { paddingValues ->
                SpeakerScreen(
                    Modifier.padding(paddingValues),
                    result.getOrThrow()
                )
            }
        }
        Route.Contributor -> {
            val result by viewModel.contributors.observeAsState(UiState.loading())
            NavigationScreen(
                result,
                "Contributors",
                onBackAction
            ) { paddingValues ->
                ContributorScreen(
                    Modifier.padding(paddingValues),
                    result.getOrThrow()
                )
            }
        }
        Route.Staff -> {
            val result by viewModel.staff.observeAsState(UiState.loading())
            NavigationScreen(
                result,
                "Staff",
                onBackAction
            ) { paddingValues ->
                StaffScreen(
                    Modifier.padding(paddingValues),
                    result.getOrThrow()
                )
            }
        }
    }
}

@Composable
private fun NavigationScreen(
    uiState: UiState<out Any>,
    title: String,
    onBackAction: () -> Unit,
    content: @Composable (PaddingValues) -> Unit
) {
    CommonContainer(uiState) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = {
                        Text(
                            text = title,
                            color = "#2F2E32".toColor(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold
                        )
                    },
                    navigationIcon = {
                        IconButton(onBackAction) {
                            Icon(
                                imageVector = Icons.Filled.ArrowBack,
                                contentDescription = null
                            )
                        }
                    },
                    backgroundColor = Color.White,
                    modifier = Modifier.fillMaxWidth()
                )
            }
        ) { innerPadding ->
            content(innerPadding)
        }
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