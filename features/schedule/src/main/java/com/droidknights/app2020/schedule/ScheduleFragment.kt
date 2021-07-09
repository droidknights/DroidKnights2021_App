package com.droidknights.app2020.schedule

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.droidknights.app2020.ui.core.compose.fragmentComposeView

class ScheduleFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return fragmentComposeView {
            ScheduleScreen()
        }
    }
}