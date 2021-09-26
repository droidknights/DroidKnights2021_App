package com.droidknights.app2021.home.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.ConcatAdapter
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.databinding.FragmentHomeBinding
import com.droidknights.app2021.home.ui.adapter.EventAdapter
import com.droidknights.app2021.home.ui.adapter.HeaderAdapter
import com.droidknights.app2021.home.ui.adapter.InfoAdapter
import com.droidknights.app2021.home.util.startOpenUrl
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()

    private var _binding: FragmentHomeBinding? = null
    private val binding: FragmentHomeBinding
        get() = requireNotNull(_binding) { "Wrong State" }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        _binding?.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.homeInfo.observe(viewLifecycleOwner) {
            val concatAdapter = ConcatAdapter(
                ConcatAdapter.Config.Builder().setIsolateViewTypes(false).build(),
                HeaderAdapter(),
                InfoAdapter(it.sponsors) { sponsor ->
                    requireContext().startOpenUrl(sponsor.homepage)
                },
                EventAdapter(it.events) { event -> requireContext().startOpenUrl(event.url) }
            )
            binding.recyclerView.adapter = concatAdapter
            binding.recyclerView.addItemDecoration(EventItemDecoration(view.context))
        }
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}