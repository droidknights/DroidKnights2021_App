package com.droidknights.app2021.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2021.home.BR
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingAdapter
import com.droidknights.app2021.home.util.DataBindingViewHolder
import com.droidknights.app2021.shared.model.Sponsor

class SponsorAdapter(
    sponsors: List<Sponsor>,
    private val itemHandler: ItemHandler
) : DataBindingAdapter<Sponsor>(DiffCallback()) {

    init {
        submitList(sponsors)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_sponsor
    }

    override fun viewBindViewHolder(holder: DataBindingViewHolder<Sponsor>, position: Int) {
        super.viewBindViewHolder(holder, position)
        holder.binding.setVariable(BR.itemHandler, itemHandler)
    }

    interface ItemHandler {
        fun clickSponsor(sponsor: Sponsor)
    }

    private class DiffCallback : DiffUtil.ItemCallback<Sponsor>() {
        override fun areItemsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem.name == newItem.name
        }

        override fun areContentsTheSame(oldItem: Sponsor, newItem: Sponsor): Boolean {
            return oldItem == newItem
        }
    }
}