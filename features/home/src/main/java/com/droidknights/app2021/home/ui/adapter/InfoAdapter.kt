package com.droidknights.app2021.home.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.droidknights.app2021.home.R
import com.droidknights.app2021.home.util.DataBindingAdapter
import com.droidknights.app2021.shared.model.Sponsor

internal class InfoAdapter(
    sponsors: List<Sponsor>
) : DataBindingAdapter<InfoItem>(DiffCallback()) {

    init {
        submitList(listOf(InfoItem(sponsors)))
    }

    override fun getItemViewType(position: Int): Int {
        return R.layout.item_info_header
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