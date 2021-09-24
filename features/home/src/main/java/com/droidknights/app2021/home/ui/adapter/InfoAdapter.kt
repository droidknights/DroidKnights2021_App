package com.droidknights.app2021.home.ui.adapter

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.lifecycle.findViewTreeLifecycleOwner
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.databinding.ItemInfoHeaderBinding
import com.droidknights.app2021.home.ui.SponsorItemDecoration
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback
import com.droidknights.app2021.home.util.recyclerview.ListBindingAdapter
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.callbackFlow
import timber.log.Timber

private const val SCROLL_DX = 5000

internal class InfoAdapter(
    private val coroutineScope: CoroutineScope,
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler
) : ListBindingAdapter<InfoItem>(ItemDiffCallback(
    onItemsTheSame = { old, new -> old.sponsors == new.sponsors },
    onContentsTheSame = { old, new -> old == new }
)) {

    private val sponsorItemHandler = object : SponsorAdapter.ItemHandler {
        override fun clickSponsor(sponsor: Sponsor) {
            itemHandler.clickSponsor(sponsor)
        }
    }

    private var scrollJob: Job? = null

    init {
        submitList(listOf(InfoItem(sponsors)))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_header
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun viewBindViewHolder(holder: DataBindingViewHolder<InfoItem>, position: Int) {
        super.viewBindViewHolder(holder, position)

        with(holder.binding as ItemInfoHeaderBinding) {
            sponsorList.adapter = SponsorAdapter(getItem(0).sponsors, sponsorItemHandler)
            sponsorList.addItemDecoration(SponsorItemDecoration())
        }

        scrollJob = coroutineScope.launch {
            holder.binding.sponsorList.launchAutoScroll(coroutineScope)
        }

        holder.binding.sponsorList.setOnTouchListener { _, event ->
            when (event.action) {
                MotionEvent.ACTION_DOWN -> {
                    scrollJob?.cancel()
                    true
                }
                MotionEvent.ACTION_UP -> {
                    scrollJob = coroutineScope.launch {
                        holder.binding.sponsorList.launchAutoScroll(coroutineScope)
                    }
                    true
                }
                else -> true
            }
        }
    }

    fun interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    private tailrec suspend fun RecyclerView.launchAutoScroll(coroutineScope: CoroutineScope) {
        val firstVisibleItem =
            (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (firstVisibleItem != RecyclerView.NO_POSITION && firstVisibleItem != 0) {
            coroutineScope.launch {
                val defferedAutoScroll = async {
                    val currentList = (adapter as SponsorAdapter).currentList
                    val secondPart = currentList.subList(0, firstVisibleItem)
                    val firstPart = currentList.subList(firstVisibleItem, currentList.size)
                    (adapter as SponsorAdapter).submitList(firstPart + secondPart)
                }
                defferedAutoScroll.await()
            }
        }
        delay(25L)
        smoothScrollBy(SCROLL_DX, 0)
        launchAutoScroll(coroutineScope)
    }
}

data class InfoItem(val sponsors: List<Sponsor>)