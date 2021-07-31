package com.droidknights.app2021.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewmodel.compose.viewModel
import com.droidknights.app2021.core.ui.compose.layout.FullScreenLoading
import com.droidknights.app2021.core.ui.compose.layout.LoadingContent
import com.droidknights.app2021.core.ui.compose.setThemeContent
import com.droidknights.app2021.core.ui.compose.state.UiState
import com.droidknights.app2021.navigator.DetailNavigator
import com.droidknights.app2021.shared.model.Session
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    @Inject
    lateinit var detailNavigator: DetailNavigator

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            ScheduleContainer { session ->
                detailNavigator.openDetail(requireContext(), session)
            }
        }
    }
}

@Composable
private fun ScheduleContainer(
    viewModel: ScheduleViewModel = viewModel(),
    onSessionClick: (Session) -> Unit = {}
) {
    val result by viewModel.sessions.observeAsState(UiState.loading())
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
                horizontalAlignment = Alignment.CenterHorizontally
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
        }
    ) {
        ScheduleScreen(
            sessions = result.getOrThrow(),
            onSessionClick = onSessionClick
        )
    }
}