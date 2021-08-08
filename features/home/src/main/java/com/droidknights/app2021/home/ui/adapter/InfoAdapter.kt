package com.droidknights.app2021.home.ui.adapter

import com.droidknights.app2021.home.BR
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.home.util.recyclerview.ItemDiffCallback
import com.droidknights.app2021.home.util.recyclerview.ListBindingAdapter
import com.droidknights.app2021.shared.model.Sponsor
import kotlinx.coroutines.CoroutineScope

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
        holder.binding.setVariable(BR.itemHandler, sponsorItemHandler)
        holder.binding.setVariable(BR.coroutineScope, coroutineScope)
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }
}

data class InfoItem(val sponsors: List<Sponsor>)