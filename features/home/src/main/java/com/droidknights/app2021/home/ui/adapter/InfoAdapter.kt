package com.droidknights.app2021.home.ui.adapter

import android.annotation.SuppressLint
import android.view.MotionEvent
import androidx.lifecycle.*
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
import timber.log.Timber

private const val SCROLL_DX = 25

internal class InfoAdapter(
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

    init {
        submitList(listOf(InfoItem(sponsors)))
    }

    class SponsorViewLifeCycleObserver(
        private val holder: DataBindingViewHolder<InfoItem>
    ) : LifecycleObserver {
        private var scrollJob: Job? = null

        @SuppressLint("ClickableViewAccessibility")
        @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
        fun startSponsorScroll() {
            scrollJob = holder.itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                (holder.binding as ItemInfoHeaderBinding).sponsorList.launchAutoScroll(
                    holder.itemView.findViewTreeLifecycleOwner()?.lifecycleScope
                )
            }

            (holder.binding as ItemInfoHeaderBinding).sponsorList.setOnTouchListener { v, event ->
                when (event.action) {
                    MotionEvent.ACTION_DOWN -> {
                        scrollJob?.cancel()
                        true
                    }
                    MotionEvent.ACTION_UP -> {
                        scrollJob =
                            holder.itemView.findViewTreeLifecycleOwner()?.lifecycleScope?.launch {
                                holder.binding.sponsorList.launchAutoScroll(
                                    holder.itemView.findViewTreeLifecycleOwner()?.lifecycleScope
                                )
                            }
                        true
                    }
                    else -> true
                }
            }
        }

        @SuppressLint("ClickableViewAccessibility")
        @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
        fun stopScroll() {
            (holder.binding as ItemInfoHeaderBinding).sponsorList.setOnTouchListener(null)
            scrollJob?.cancel()
        }

        private tailrec suspend fun RecyclerView.launchAutoScroll(lifeCycleScope: LifecycleCoroutineScope?) {
            Timber.d("Call launchAutoScroll")
            val firstVisibleItem =
                (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
            if (firstVisibleItem != RecyclerView.NO_POSITION && firstVisibleItem != 0) {
                lifeCycleScope?.launch {
                    val defferedAutoScroll = async {
                        val currentList = (adapter as SponsorAdapter).currentList.toMutableList()
                        val secondPart = currentList.subList(0, REPLACE_POSITION)
                        val firstPart = currentList.subList(REPLACE_POSITION, currentList.size)
                        val newList = mutableListOf<Sponsor>().apply {
                            addAll(firstPart)
                            addAll(secondPart)
                        }
                        (adapter as SponsorAdapter).submitList(newList)
                    }
                    defferedAutoScroll.await()
                }
            }
            delay(25L)
            smoothScrollBy(SCROLL_DX, 0)
            launchAutoScroll(lifeCycleScope)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_header
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<InfoItem>, position: Int) {
        super.viewBindViewHolder(holder, position)

        with(holder.binding as ItemInfoHeaderBinding) {
            sponsorList.adapter = SponsorAdapter(getItem(0).sponsors, sponsorItemHandler)
            sponsorList.addItemDecoration(SponsorItemDecoration())
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onViewAttachedToWindow(holder: DataBindingViewHolder<InfoItem>) {
        super.onViewAttachedToWindow(holder)

        holder.itemView.findViewTreeLifecycleOwner()
            ?.lifecycle
            ?.addObserver(SponsorViewLifeCycleObserver(holder))
    }

    fun interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    companion object {
        private const val REPLACE_POSITION = 1
    }
}

data class InfoItem(val sponsors: List<Sponsor>)