package com.droidknights.app2021.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2021.home.BR
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingAdapter
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.shared.model.Sponsor

internal class InfoAdapter(
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler
) : DataBindingAdapter<InfoItem>(DiffCallback()) {

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
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    private class DiffCallback : DiffUtil.ItemCallback<InfoItem>() {
        override fun areItemsTheSame(oldItem: InfoItem, newItem: InfoItem): Boolean {
            return oldItem.sponsors == newItem.sponsors
        }

        override fun areContentsTheSame(oldItem: InfoItem, newItem: InfoItem): Boolean {
            return oldItem.sponsors == newItem.sponsors
        }
    }
}

data class InfoItem(val sponsors: List<Sponsor>)