package com.droidknights.app2021.home.ui.adapter

import android.os.Handler
import android.os.Looper
import androidx.compose.runtime.LaunchedEffect
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.databinding.ItemInfoHeaderBinding
import com.droidknights.app2021.home.ui.SponsorItemDecoration
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback
import com.droidknights.app2021.home.util.recyclerview.ListBindingAdapter
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import timber.log.Timber

private const val SCROLL_DX = 5

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

    init {
        submitList(listOf(InfoItem(sponsors)))
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

        coroutineScope.launch {
            (holder.binding as ItemInfoHeaderBinding).sponsorList.launchAutoScroll()
        }
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    private tailrec suspend fun RecyclerView.launchAutoScroll() {
        smoothScrollBy(SCROLL_DX, 0)
        val firstVisibleItem =
            (layoutManager as LinearLayoutManager).findFirstVisibleItemPosition()
        if (firstVisibleItem != RecyclerView.NO_POSITION) {
            if (firstVisibleItem != 0) {
                val currentList = (adapter as SponsorAdapter).currentList
                val secondPart = currentList.subList(0, 1)
                val firstPart = currentList.subList(1, currentList.size)
                (adapter as SponsorAdapter).submitList(firstPart + secondPart)
            }
        }
        delay(25L)
        launchAutoScroll()
    }
}

data class InfoItem(val sponsors: List<Sponsor>)