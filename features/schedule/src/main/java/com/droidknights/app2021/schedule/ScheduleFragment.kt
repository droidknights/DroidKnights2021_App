package com.droidknights.app2021.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.droidknights.app2021.navigator.DetailNavigator
import com.droidknights.app2021.shared.result.Result
import com.droidknights.app2021.ui.core.compose.setThemeContent
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber
import javax.inject.Inject

@AndroidEntryPoint
class ScheduleFragment : Fragment() {

    @Inject
    lateinit var detailNavigator: DetailNavigator

    private val viewModel by viewModels<ScheduleViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return setThemeContent {
            val sessionResult by viewModel.sessions.observeAsState()
            sessionResult?.let { result ->
                when (result) {
                    is Result.Loading -> {
                        Column(
                            modifier = Modifier.fillMaxSize(),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            CircularProgressIndicator(Modifier.size(48.dp))
                        }
                    }
                    is Result.Success -> {
                        ScheduleScreen(
                            sessions = result.data
                        ) { session ->
                            detailNavigator.openDetail(requireContext(), session)
                        }
                    }
                    is Result.Error -> {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(24.dp),
                            verticalArrangement = Arrangement.Center,
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.ic_error_black_24),
                                modifier = Modifier.size(64.dp),
                                contentDescription = null
                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            Text(text = result.exception.localizedMessage.orEmpty())
                            Timber.e(result.exception)
                        }
                    }
                }
            }
        }
    }
}