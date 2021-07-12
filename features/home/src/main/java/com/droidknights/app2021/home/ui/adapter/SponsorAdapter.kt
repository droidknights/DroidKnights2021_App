package com.droidknights.app2021.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingAdapter
import com.droidknights.app2021.shared.model.Sponsor

internal class SponsorAdapter(
    sponsors: List<Sponsor>
) : DataBindingAdapter<Sponsor>(DiffCallback()) {

    init {
        submitList(sponsors)
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_sponsor
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